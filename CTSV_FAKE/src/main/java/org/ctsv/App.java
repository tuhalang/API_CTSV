package org.ctsv;

import com.google.gson.internal.$Gson$Preconditions;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.ctsv.model.Activity;
import org.ctsv.model.RespActivity;
import org.ctsv.model.RespLogin;
import org.ctsv.model.RespUpload;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static String _username = "";
    private static String _tokencode = "";
    private static boolean _isLogin = false;
    private static String _signature = "";

    private static void showMenu(WebService service){
        Scanner scanner = new Scanner(System.in);
        if(!_isLogin){
            System.out.println("Login System !!!");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            RespLogin respLogin = login(service, username, password);
            if(respLogin.getTokenCode() != null && !respLogin.getTokenCode().equals("")){
                System.out.println("Login Successfully !!!");
                _isLogin = true;
                _username = respLogin.getUserName();
                _signature = respLogin.getSignature();
                _tokencode = respLogin.getTokenCode();
            }else{
                System.out.println("Username/Password invalid !!!");
            }
        }else{
            System.out.println("1. List activities");
            System.out.println("2. Upload proof image (require AId)");
            System.out.println("3. CheckIn (require AId)");
            System.out.print("Choose: ");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    List<Activity> activities = getActivities(service, _username, _tokencode, _username);
                    System.out.println(activities);
                    break;
                case 2:
                    System.out.print("Enter path to image in your device: ");
                    String path = scanner.nextLine();
                    System.out.print("Enter AId: ");
                    int AId = scanner.nextInt();
                    uploadImage(service, _username, _tokencode, AId, path);
                    break;
                case 3:
                    System.out.print("Enter AId: ");
                    int Aid = scanner.nextInt();
                    checkIn(service, _username, _tokencode, _username, Aid, ConstantsKt.longitude, ConstantsKt.latitude, ConstantsKt.address, _signature);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        WebService service = getService(1);
        while(true){
            showMenu(service);
        }
    }

    private static WebService getService(int type) {
        OkHttpClient.Builder client = new OkHttpClient().newBuilder()
                .addInterceptor(new AuthenticationInterceptor())
                .addNetworkInterceptor(new AuthenticationInterceptor());

        switch (type) {
            case 1:
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy-tct", 3128));
                client.proxy(proxy);
                break;
            default:
                break;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsKt.API_SERVICE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
        WebService service = retrofit.create(WebService.class);
        return service;
    }

    private static RespLogin login(WebService service, String username, String password) {
        Call<RespLogin> callSync = service.login(username, password);

        try {
            Response<RespLogin> response = callSync.execute();
            RespLogin apiResponse = response.body();
            logger.info("ResponseLogin: " + apiResponse);
            return apiResponse;
        } catch (Exception ex) {
            logger.severe(ex.getMessage());
            return null;
        }
    }

    private static List<Activity> getActivities(WebService service, String UserName, String token, String UserCode) {
        Call<RespActivity> callSync = service.getActivityByUser(UserName, token, UserCode);

        try {
            Response<RespActivity> response = callSync.execute();
            RespActivity apiResponse = response.body();
            logger.info("ResponseActivities: " + apiResponse);
            return apiResponse.getActivities();
        } catch (Exception ex) {
            logger.severe(ex.getMessage());
            return null;
        }
    }

    private static Object uploadImage(WebService service, String UserCode, String TokenCode, int AId, String pathFile) {
        File file = new File(pathFile);

        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));

        Call<Object> callSync = service.uploadFile(UserCode, TokenCode, AId, filePart);

        try {
            Response<Object> response = callSync.execute();
            Object apiResponse = response.body();
            logger.info("ResponseUpload: " + apiResponse);
            return apiResponse;

        } catch (Exception ex) {
            logger.severe(ex.getMessage());
            return null;
        }
    }

    private static Object checkIn(WebService service, String UserName, String TokenCode, String UserCode, int AId, double Longitude, double Latitude, String Address, String Signature) {
        Call<Object> callSync = service.userCheckinActivity(UserName, TokenCode, UserCode, AId, Longitude, Latitude, Address, Signature);

        try {
            Response<Object> response = callSync.execute();
            Object apiResponse = response.body();
            logger.info("ResponseCheckIn: " + apiResponse);
            return apiResponse;

        } catch (Exception ex) {
            logger.severe(ex.getMessage());
            return null;
        }
    }
}
