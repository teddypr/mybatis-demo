package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.User;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {

    @Autowired //やや重要！　Spring Framework によって DI される
    //DI=Dependency Injection の略で、依存性の注入という意味
    UserMapper userMapper;

    @Test
//test-method の前に delete,insert をする
//        @Sql(
//                scripts = {"classpath:/sqlannotation/delete-users.sql", "classpath:/sqlannotation/insert-users.sql"},
//                executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
//        )

    @DataSet(value = "datasets/users.yml")
//    @Transactional
//    void 指定したIDのユーザーを取得できること() {
//        Optional<User> actual = userMapper.findById(1);
//        assertThat(actual).hasValue(new User(1, "Alice", "alice@example"));
//    }

    @Transactional
    void すべてのユーザーが取得できること() {
        List<User> users = userMapper.findAllusers();
        assertThat(users)
                .hasSize(2)
                .contains(
                        new User(1, "Alice", "alice@example.com"),
                        new User(2, "Bob", "bob@example.com"));
    }

    @Test
    @Transactional
    void 存在しないIDを指定した場合は空のOptionalが返ること() {
        Optional<User> actual = userMapper.findById(100);
        assertThat(actual).isEmpty();
    }

    @Test
    @Transactional
    void 指定したIDのユーザーを取得できること() {
        Optional<User> actual = userMapper.findById(1);
        assertThat(actual.get()).isEqualTo(new User(1, "Alice", "alice@example.com"));
    }

}

