package com.example.mybatisdemo.controller.contoroller;

import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.controller.request.UserRequest;
import com.example.mybatisdemo.controller.response.UserResponse;
import com.example.mybatisdemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * ユーザー情報に関して HTTPリクエスト を受け付けるコントローラー
 */
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> insert(@RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        User user = userService.insert(userRequest.getName(), userRequest.getEmail());
        URI location = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        UserResponse body = new UserResponse("user created");
        return ResponseEntity.created(location).body(body);
    }


}
