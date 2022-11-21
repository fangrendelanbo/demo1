package com.example.demo1.model;


public class Sp {
    private int id;

    private String name;

    private int bh;

    private int sl;

    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }

    public int getBh() {

        return bh;
    }
    public void setBh(int bh) {

        this.bh = bh;
    }
    public int getSl() {

        return sl;
    }
    public void setSl(int sl) {

        this.sl = sl;
    }
    @Override
    public String toString() {
        return this.id+" "+this.name+" "+this.bh+" "+this.sl;
    }

    public void Sp(int id, String name, int bh , int sl) {
        this.id = id;
        this.name = name;
        this.bh = bh;
        this.sl = sl;
    }
}
