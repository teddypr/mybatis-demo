package com.example.mybatisdemo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // MyBatisのMapperである⽬印として@Mapperアノテーションを付与する
public interface NameMapper { // classではなくinterfaceで定義する

    @Select("SELECT * FROM names")
    List<Name> findAll();

    // prefixは接頭辞という意味
    @Select("SELECT * FROM names WHERE name LIKE CONCAT(#{prefix}, '%')")
    List<Name> findByNameStartingWith(String prefix);

}
