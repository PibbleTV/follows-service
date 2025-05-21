package com.pibbletv.follows_service.persistance.repository;

import com.pibbletv.follows_service.persistance.entities.FollowingEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface FollowingRepository extends ReactiveCrudRepository<FollowingEntity, Long> {

    Flux<FollowingEntity> findByFollowedId(String followedId);

    Flux<FollowingEntity> findByFollowerId(String followerId);
}
