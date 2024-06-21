package com.example.mybatisdemo.controller.request;

/**
 * ユーザー情報登録時に使うリクエストパラメータ
 */
public class UserRequest {

    private String name;
    private  String email;


// 項目が name など１つしかない時は、JsonCreatorを使う
//    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)

    public UserRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
