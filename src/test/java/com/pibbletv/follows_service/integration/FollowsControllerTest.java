package com.pibbletv.follows_service.integration;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.pibbletv.follows_service.business.converters.FollowingConverter;
import com.pibbletv.follows_service.business.implementations.FollowingServiceImpl;
import com.pibbletv.follows_service.business.interfaces.FollowingService;
import com.pibbletv.follows_service.domain.Following;
import com.pibbletv.follows_service.persistance.entities.FollowingEntity;
import com.pibbletv.follows_service.persistance.repository.FollowingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureWebTestClient
public class FollowsControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @InjectMocks
    private FollowingServiceImpl followingService;

    @Mock
    private FollowingRepository followingRepository;

//    @Test
//    void followUser_shouldReturn200_whenUserIsFollowed() {
//
//
//        Following following = new Following(1L, 1L, 2L);
//        FollowingEntity entity = FollowingConverter.convertToEntity(following);
//
//        when(followingRepository.save(entity)).thenReturn(Mono.empty());
//        when(followingService.followUser(following)).thenReturn(Mono.empty());
//
//        webTestClient.post()
//                .uri("/following/followUser")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(following)
//                .exchange()
//                .expectStatus().isOk();
//    }
//
//    @Test
//    void unfollowUser_shouldReturn200_whenUserIsUnfollowed() {
//        Following following = new Following(1L, 1L, 2L);
//        FollowingEntity entity = FollowingConverter.convertToEntity(following);
//
//        when(followingRepository.save(entity)).thenReturn(Mono.empty());
//        when(followingService.unfollowUser(following)).thenReturn(Mono.empty());
//
//        webTestClient.method(HttpMethod.DELETE)
//                .uri("/following/unfollowUser")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(following))
//                .exchange()
//                .expectStatus().isOk();
//    }
//
//    @Test
//    void getFollowers_shouldReturnFollowersList_whenRequestIsInvoked() {
//        Long userId = 2L;
//
//        Following following1 = new Following(1L, 1L, 2L);
//        Following following2 = new Following(2L, 3L, 2L);
//
//        when(followingRepository.findByFollowedId(userId)).thenReturn(Flux.just(
//                FollowingConverter.convertToEntity(following1),
//                FollowingConverter.convertToEntity(following2)
//        ));
//        when(followingService.getFollowers(userId)).thenReturn(Flux.just(following1, following2));
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/following/getFollowers")
//                        .queryParam("userId", userId)
//                        .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
//                .expectBodyList(Following.class);
//    }
//
//    @Test
//    void getFollowing_shouldReturnFollowingList_whenRequestIsInvoked() {
//        Long userId = 1L;
//
//        Following following1 = new Following(1L, 1L, 2L);
//        Following following2 = new Following(2L, 1L, 3L);
//
//        when(followingRepository.findByFollowerId(userId)).thenReturn(Flux.just(
//                FollowingConverter.convertToEntity(following1),
//                FollowingConverter.convertToEntity(following2)
//        ));
//        when(followingService.getFollowing(userId)).thenReturn(Flux.just(following1, following2));
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/following/getFollowing")
//                        .queryParam("userId", userId)
//                        .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
//                .expectBodyList(Following.class);
//    }
//
//    @Test
//    void getFollowers_shouldReturnEmptyList_whenRequestIsInvoked() {
//        Long userId = 2L;
//
//        when(followingRepository.findByFollowedId(userId)).thenReturn(Flux.empty());
//        when(followingService.getFollowing(userId)).thenReturn(Flux.empty());
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/following/getFollowers")
//                        .queryParam("userId", userId)
//                        .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
//                .expectBodyList(Following.class);
//    }
//
//    @Test
//    void getFollowing_shouldReturnEmptyList_whenRequestIsInvoked() {
//        Long userId = 1L;
//
//        when(followingRepository.findByFollowerId(userId)).thenReturn(Flux.empty());
//        when(followingService.getFollowing(userId)).thenReturn(Flux.empty());
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/following/getFollowing")
//                        .queryParam("userId", userId)
//                        .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
//                .expectBodyList(Following.class);
//    }
}
