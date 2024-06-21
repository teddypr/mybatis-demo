package com.example.mybatisdemo.entity;

import java.util.Objects;

/**
 * ユーザーテーブル用エンティティ
 */

public class Name {

    private int id;

    private String name;


    public Name(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return id == name1.id && Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


    @Override
    public String toString() {
        //json 形式で返す
        return "{\"id\":" + id + ",\"name\":\"" + name + "\"}";
    }


//                "Name{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//        '}';

}
