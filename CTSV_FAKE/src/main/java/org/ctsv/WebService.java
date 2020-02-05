package org.ctsv;

import okhttp3.MultipartBody;
import org.ctsv.model.RespActivity;
import org.ctsv.model.RespLogin;
import retrofit2.Call;
import retrofit2.http.*;

public interface WebService {

    @FormUrlEncoded
    @POST("User/UserLogin")
    Call<RespLogin> login(@Field("UserName") String str,
                          @Field("Password") String str2);

    @Multipart
    @POST("UploadFile/CTSV/UploadProofImage")
    Call<Object> uploadFile(@Query("UserCode") String str,
                            @Query("TokenCode") String str2,
                            @Query("AId") int i,
                            @Part MultipartBody.Part part);

    @FormUrlEncoded
    @POST("Activity/GetActivityByUser")
    Call<RespActivity> getActivityByUser(@Field("UserName") String str,
                                         @Field("TokenCode") String str2,
                                         @Field("UserCode") String str3);

    @FormUrlEncoded
    @POST("Activity/UserCheckinActivity")
    Call<Object> userCheckinActivity(@Field("UserName") String str,
                                     @Field("TokenCode") String str2,
                                     @Field("UserCode") String str3,
                                     @Field("AId") int i,
                                     @Field("Longitude") double d,
                                     @Field("Latitude") double d2,
                                     @Field("Address") String str4,
                                     @Field("Signature") String str5);

    @FormUrlEncoded
    @POST("User/LogOut")
    Call<Object> logout(@Field("UserName") String str,
                        @Field("TokenCode") String str2,
                        @Field("Signature") String str3);
}
