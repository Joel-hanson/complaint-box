package com.example.achal.complaintbox;

/**
 * Created by joel on 4/8/2016.
 */
public class user{

        String uid,password,name,yob,house,state,district,pc;



public user(){

        }


public user(String uid, String password, String name, String yob, String house, String state, String district, String pc) {
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.yob = yob;
        this.house = house;
        this.state = state;
        this.district = district;
        this.pc = pc;


        }

public String getUid() {
        return uid;
        }

public void setUid(String uid) {
        this.uid = uid;
        }

public String getPassword() {
        return password;
        }

public void setPassword(String password) {
        this.password = password;
        }

public String getName() {
        return name;
        }

public void setName(String name) {
        this.name = name;
        }

public String getYob() {
        return yob;
        }

public void setYob(String yob) {
        this.yob = yob;
        }

public String getHouse() {
        return house;
        }

public void setHouse(String house) {
        this.house = house;
        }

public String getState() {
        return state;
        }

public void setState(String state) {
        this.state = state;
        }

public String getDistrict() {
        return district;
        }

public void setDistrict(String district) {
        this.district = district;
        }

public String getPc() {
        return pc;
        }

public void setPc(String pc) {
        this.pc = pc;
        }


}
