package com.ccmdb.movies.tc;

import org.junit.jupiter.api.BeforeEach;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.MediaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.testcontainers.containers.MockServerContainer;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.nio.file.Files;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class AbstractContainerBaseTest {

    private static final DockerImageName MOCKSERVER_IMAGE = DockerImageName.parse("mockserver/mockserver:mockserver-5.11.2");
    private static final int OK = 200;

    static MockServerContainer MOCKSERVER_CONTAINER;

    static {
        MOCKSERVER_CONTAINER = new MockServerContainer(MOCKSERVER_IMAGE);
        MOCKSERVER_CONTAINER.start();
    }

    @BeforeEach
    void setUp() throws IOException {
        setupPlatformApiMockExpectations();

    }

    public static class MockServerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues
                    .of("blockbusted.url=" + MOCKSERVER_CONTAINER.getEndpoint())
                    .applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Value("classpath:mockInitialiser.json")
    private Resource mockDataResource;


    private void setupPlatformApiMockExpectations() throws IOException {
        String expectedMoviesBody = new String(
                Files.readAllBytes(mockDataResource.getFile()
                        .toPath()));

        MockServerClient client = new MockServerClient(MOCKSERVER_CONTAINER.getHost(), MOCKSERVER_CONTAINER.getServerPort());

        client.when(request()
                        .withMethod("GET")
                        .withPath("/movies"))
                .respond(response()
                        .withBody(expectedMoviesBody)
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withStatusCode(OK));

    }
}