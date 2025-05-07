package com.pibbletv.follows_service.integration;

import com.pibbletv.follows_service.domain.Following;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest
@AutoConfigureWebTestClient
public class FollowsControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void followUser_shouldReturn200_whenUserIsFollowed() {
        Following following = new Following(null, 1L, 2L);

        webTestClient.post()
                .uri("/following/followUser")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(following)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void unfollowUser_shouldReturn200_whenUserIsUnfollowed() {
        Following following = new Following(null, 1L, 2L);

        webTestClient.method(HttpMethod.DELETE)
                .uri("/following/unfollowUser")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(following))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void getFollowers_shouldReturnFollowersList_whenRequestIsInvoked() {
        Long userId = 2L;

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/following/getFollowers")
                        .queryParam("userId", userId)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBodyList(Following.class);
    }

    @Test
    void getFollowing_shouldReturnFollowingList_whenRequestIsInvoke() {
        Long userId = 1L;

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/following/getFollowing")
                        .queryParam("userId", userId)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBodyList(Following.class);
    }
}


