package com.example.mybatisdemo.integration;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

/**
 * 結合テスト
 */
@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRestApiIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DataSet(value = "datasets/users.yml")
    @Transactional
    void ユーザーが全件取得できること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //text block を使って json をアサーションする
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                                "id":1, 
                　　　　　　　　　　"name":"Alice",
               　　　　　　　　　　 "email":"alice@example.com"
        　　　　　　　　　　　　　　　"id":2, 
                　　　　　　　　　　"name":"Bob",
               　　　　　　　　　　 "email":"bob@example.com"
                        }
                        """));
    }

}
