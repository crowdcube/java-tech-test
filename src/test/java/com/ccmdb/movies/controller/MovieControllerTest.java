package com.ccmdb.movies.controller;

import com.ccmdb.movies.tc.AbstractContainerBaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = AbstractContainerBaseTest.MockServerInitializer.class)
class MovieControllerTest extends AbstractContainerBaseTest {

    @LocalServerPort
    int port;

    @Test
    void contextLoads() {

    }
}
