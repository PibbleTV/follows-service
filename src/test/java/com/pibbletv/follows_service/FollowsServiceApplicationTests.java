package com.pibbletv.follows_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(properties = {
        "spring.r2dbc.url=r2dbc:h2:mem:///testdb;DB_CLOSE_DELAY=-1",
        "spring.r2dbc.username=sa",
        "spring.r2dbc.password=",
        "spring.r2dbc.pool.enabled=false"
})
class FollowsServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
