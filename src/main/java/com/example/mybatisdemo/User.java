package com.example.mybatisdemo;

public class Name {

    private int id;

    private String name;

    private String tel;

    public Name(int id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }
}
