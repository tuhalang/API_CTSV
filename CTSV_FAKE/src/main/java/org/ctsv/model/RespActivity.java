package org.ctsv.model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class RespActivity {

    private int RespCode;
    private String RespText;
    private List<Activity> Activities = new ArrayList<>();
    private String Signature;
    private int NumberPage;

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

    public List<Activity> getActivities() {
        return Activities;
    }

    public void setActivities(List<Activity> activities) {
        Activities = activities;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public int getNumberPage() {
        return NumberPage;
    }

    public void setNumberPage(int numberPage) {
        NumberPage = numberPage;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
