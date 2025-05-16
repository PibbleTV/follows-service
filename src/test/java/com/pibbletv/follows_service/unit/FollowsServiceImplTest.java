//package com.pibbletv.follows_service.unit;
//
//import com.pibbletv.follows_service.business.implementations.FollowingServiceImpl;
//import com.pibbletv.follows_service.domain.Following;
//import com.pibbletv.follows_service.persistance.entities.FollowingEntity;
//import com.pibbletv.follows_service.persistance.repository.FollowingRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import static org.mockito.Mockito.*;
//
//@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
//public class FollowsServiceImplTest {
//
//    @Mock
//    private FollowingRepository followingRepository;
//
//    @InjectMocks
//    private FollowingServiceImpl followingService;
//
//    @Test
//    void followUser_shouldCompleteSuccessfully() {
//        Following following = new Following(null, 1L, 2L);
//        FollowingEntity entity = new FollowingEntity(null , 1L, 2L);
//
//        when(followingRepository.save(entity)).thenReturn(Mono.empty());
//
//        StepVerifier.create(followingService.followUser(following))
//                .verifyComplete();
//
//        verify(followingRepository, times(1)).save(entity);
//
//    }
//
//    @Test
//    void followUser_shouldReturnError_whenRepositoryFails() {
//        Following following = new Following(null, 1L, 2L);
//        FollowingEntity entity = new FollowingEntity(null , 1L, 2L);
//
//        when(followingRepository.save(entity)).thenReturn(Mono.error(new RuntimeException("DB error")));
//
//        StepVerifier.create(followingService.followUser(following))
//                .expectErrorMatches(throwable -> throwable instanceof RuntimeException &&
//                        throwable.getMessage().equals("DB error"))
//                .verify();
//        }
//
//
//    @Test
//    void unfollowUser_shouldCompleteSuccessfully() {
//        Following following = new Following(null, 1L, 2L);
//        FollowingEntity entity = new FollowingEntity(null , 1L, 2L);
//
//        when(followingRepository.delete(entity)).thenReturn(Mono.empty());
//
//        StepVerifier.create(followingService.unfollowUser(following))
//                .verifyComplete();
//
//        verify(followingRepository, times(1)).delete(entity);
//
//    }
//
//    @Test
//    void unfollowUser_shouldReturnError_whenRepositoryFails() {
//        Following following = new Following(null, 1L, 2L);
//        FollowingEntity entity = new FollowingEntity(null , 1L, 2L);
//
//        when(followingRepository.delete(entity)).thenReturn(Mono.error(new RuntimeException("Delete failed")));
//
//        StepVerifier.create(followingService.unfollowUser(following))
//                .expectErrorMatches(throwable -> throwable instanceof RuntimeException &&
//                        throwable.getMessage().equals("Delete failed"))
//                .verify();
//    }
//
//    @Test
//    void getFollowers_shouldReturnListOfFollowers() {
//        Long userId = 2L;
//        Following following = new Following(1L, 1L, 2L);
//        FollowingEntity entity = new FollowingEntity(1L , 1L, 2L);
//
//        when(followingRepository.findByFollowedId(userId)).thenReturn(Flux.just(entity));
//
//        StepVerifier.create(followingService.getFollowers(userId))
//                .expectNext(following)
//                .verifyComplete();
//    }
//
//    @Test
//    void getFollowers_shouldReturnError_whenRepositoryFails() {
//        Long userId = 2L;
//
//        when(followingRepository.findByFollowedId(userId))
//                .thenReturn(Flux.error(new RuntimeException("Error finding followers")));
//
//        StepVerifier.create(followingService.getFollowers(userId))
//                .expectErrorMatches(throwable -> throwable instanceof RuntimeException &&
//                        throwable.getMessage().equals("Error finding followers"))
//                .verify();
//    }
//
//    @Test
//    void getFollowing_shouldReturnListOfFollowing() {
//        Long userId = 1L;
//        Following following = new Following(1L, 1L, 2L);
//        FollowingEntity entity = new FollowingEntity(1L , 1L, 2L);
//
//        when(followingRepository.findByFollowerId(userId)).thenReturn(Flux.just(entity));
//
//
//
//        StepVerifier.create(followingService.getFollowing(userId))
//                .expectNext(following)
//                .verifyComplete();
//
//    }
//
//    @Test
//    void getFollowing_shouldReturnError_whenRepositoryFails() {
//        Long userId = 1L;
//
//        when(followingRepository.findByFollowerId(userId))
//                .thenReturn(Flux.error(new RuntimeException("Fetch failed")));
//
//        StepVerifier.create(followingService.getFollowing(userId))
//                .expectErrorMatches(throwable -> throwable instanceof RuntimeException &&
//                        throwable.getMessage().equals("Fetch failed"))
//                .verify();
//    }
//
//}
