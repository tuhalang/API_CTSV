package org.ctsv.model;

import com.google.gson.Gson;

import java.util.Date;

public class Activity {

    private int AId;
    private int ACode;
    private String AName;
    private String AType;
    private String ADesc;
    private Date StartTime;
    private Date FinishTime;
    private String APlace;
    private int GId;
    private String GName;
    private String Data;
    private Date CreateDate;
    private String CreateUser;
    private int AStatus;
    private int UAStatus;
    private String ARefId;
    private String ACriteriaLst;
    private String AGDesc;
    private int UserRole;

    public int getAId() {
        return AId;
    }

    public void setAId(int AId) {
        this.AId = AId;
    }

    public int getACode() {
        return ACode;
    }

    public void setACode(int ACode) {
        this.ACode = ACode;
    }

    public String getAName() {
        return AName;
    }

    public void setAName(String AName) {
        this.AName = AName;
    }

    public String getAType() {
        return AType;
    }

    public void setAType(String AType) {
        this.AType = AType;
    }

    public String getADesc() {
        return ADesc;
    }

    public void setADesc(String ADesc) {
        this.ADesc = ADesc;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getFinishTime() {
        return FinishTime;
    }

    public void setFinishTime(Date finishTime) {
        FinishTime = finishTime;
    }

    public String getAPlace() {
        return APlace;
    }

    public void setAPlace(String APlace) {
        this.APlace = APlace;
    }

    public int getGId() {
        return GId;
    }

    public void setGId(int GId) {
        this.GId = GId;
    }

    public String getGName() {
        return GName;
    }

    public void setGName(String GName) {
        this.GName = GName;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public String getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(String createUser) {
        CreateUser = createUser;
    }

    public int getAStatus() {
        return AStatus;
    }

    public void setAStatus(int AStatus) {
        this.AStatus = AStatus;
    }

    public int getUAStatus() {
        return UAStatus;
    }

    public void setUAStatus(int UAStatus) {
        this.UAStatus = UAStatus;
    }

    public String getARefId() {
        return ARefId;
    }

    public void setARefId(String ARefId) {
        this.ARefId = ARefId;
    }

    public String getACriteriaLst() {
        return ACriteriaLst;
    }

    public void setACriteriaLst(String ACriteriaLst) {
        this.ACriteriaLst = ACriteriaLst;
    }

    public String getAGDesc() {
        return AGDesc;
    }

    public void setAGDesc(String AGDesc) {
        this.AGDesc = AGDesc;
    }

    public int getUserRole() {
        return UserRole;
    }

    public void setUserRole(int userRole) {
        UserRole = userRole;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
