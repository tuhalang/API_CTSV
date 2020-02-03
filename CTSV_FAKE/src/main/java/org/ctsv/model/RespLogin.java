package org.ctsv.model;

import com.google.gson.Gson;

public class RespLogin {
    private int RespCode;
    private String RespText;
    private String UserName;
    private String FullName;
    private String Email;
    private int Utype;
    private String Avatar;
    private String TokenCode;
    private String Signature;

    public int getRespCode() {
        return RespCode;
    }

    public void setRespCode(int respCode) {
        RespCode = respCode;
    }

    public String getRespText() {
        return RespText;
    }

    public void setRespText(String respText) {
        RespText = respText;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getUtype() {
        return Utype;
    }

    public void setUtype(int utype) {
        Utype = utype;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getTokenCode() {
        return TokenCode;
    }

    public void setTokenCode(String tokenCode) {
        TokenCode = tokenCode;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
