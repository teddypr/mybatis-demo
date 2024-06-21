package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

/**
 * ユーザーテーブル用のマッパー
 */
@Mapper
public interface UserMapper {

    // SELECT用のMapper
    // 全てのstudentのデータを全て取得します。
    @Select("SELECT * FROM users")
    List<User> findAllusers();

    //SELECT用のMapper
    //指定したidのuserのデータを全て取得します。
    @Select("SELECT * FROM users WHERE id = #{id} ")
    Optional<User> findById(int id);

    //インサート用のMapper
    @Insert("INSERT INTO users (name, email) VALUES (#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

}
