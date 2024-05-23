package com.example.mybatisdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NameController {

    //fild に NameMapper を追記
    private NameMapper nameMapper;

    //Dependecy Injection によって NameMapper インスタンスが渡される。
    public NameController(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

//    @GetMapping("/names")
//    public List<Name> getNames() {
//        //nameMapperのfindAllを呼び出す。
//        //そして、その結果を返す
//        List<Name> names = nameMapper.findAll();
//        return names;
//    }

    //リクエストパラム
    @GetMapping("/names")
    public List<Name> findByNames(@RequestParam String startsWith) {
        return nameMapper.findByNameStartingWith(startsWith);
    }


}
