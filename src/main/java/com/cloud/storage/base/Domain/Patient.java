package com.cloud.storage.base.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "patient")
public class Patient implements Serializable {
    private static final long serialVersionUID = 2284954391490103232L;

    public Patient() {
    }

    @Id
    private Integer patientId;
    private String idcard;
    //    姓名
    private String name;
    //    联系电话
    private String phone;
    private String email;
    private String deviceId;
    private String appType;
    //    性别
    private Integer sex;
    private String birth;
    //    年龄
    private String age;
    //    单位
    private String unit;
    //    部门
    private String dept;
//    Constructors


    public Patient(String appType) {
        this.appType = appType;
    }

    public Patient(String idcard, String name, String phone, String email, String deviceId, String appType, Integer sex, String birth) {
        this.idcard = idcard;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.deviceId = deviceId;
        this.appType = appType;
        this.sex = sex;
        this.birth = birth;
    }


    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
