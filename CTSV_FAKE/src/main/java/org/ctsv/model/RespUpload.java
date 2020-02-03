package org.ctsv.model;

import com.google.gson.Gson;

public class RespUpload {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
