package com.example.demo1.model;

public class Orders {

    private int spid;

    private String spname;

    private String buytime;

    private String number;
    private String userName;

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }
    public String getNumber() {

        return number;
    }

    public void setNumber(String number) {

        this.number = number;
    }

    public int getSpid() {

        return spid;
    }

    public void setSpid(int spid) {

        this.spid = spid;
    }

    public String getSpname() {

        return spname;
    }

    public void setSpname(String spname) {

        this.spname = spname;
    }

    public String getBuytime() {

        return buytime;
    }

    public void setBuytime(String buytime) {

        this.buytime = buytime;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return this.spid+" "+this.spname+" "+this.buytime+" "+this.number;
    }

    public Orders(int spid, String spname, String buytime , String number) {
        this.spid = spid;
        this.spname = spname;
        this.buytime = buytime;
        this.number = number;
    }
}
