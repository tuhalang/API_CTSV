package org.ctsv;

import com.sun.istack.internal.NotNull;
import okhttp3.MultipartBody;
import org.ctsv.model.RespActivity;
import org.ctsv.model.RespLogin;
import org.ctsv.model.RespUpload;
import retrofit2.Call;
import retrofit2.http.*;

public interface WebService {

    @FormUrlEncoded
    @NotNull
    @POST("User/UserLogin")
    Call<RespLogin> login(@NotNull @Field("UserName") String str,
                          @NotNull @Field("Password") String str2);

    @Multipart
    @NotNull
    @POST("UploadFile/CTSV/UploadProofImage")
    Call<Object> uploadFile(@NotNull @Query("UserCode") String str,
                            @NotNull @Query("TokenCode") String str2,
                            @Query("AId") int i,
                            @NotNull @Part MultipartBody.Part part);

    @FormUrlEncoded
    @NotNull
    @POST("Activity/GetActivityByUser")
    Call<RespActivity> getActivityByUser(@NotNull @Field("UserName") String str,
                                         @NotNull @Field("TokenCode") String str2,
                                         @NotNull @Field("UserCode") String str3);

    @FormUrlEncoded
    @NotNull
    @POST("Activity/UserCheckinActivity")
    Call<Object> userCheckinActivity(@NotNull @Field("UserName") String str,
                                     @NotNull @Field("TokenCode") String str2,
                                     @NotNull @Field("UserCode") String str3,
                                     @Field("AId") int i,
                                     @Field("Longitude") double d,
                                     @Field("Latitude") double d2,
                                     @NotNull @Field("Address") String str4,
                                     @NotNull @Field("Signature") String str5);
}
