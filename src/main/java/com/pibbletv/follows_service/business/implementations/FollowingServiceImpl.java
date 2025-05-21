package com.pibbletv.follows_service.business.implementations;

import com.pibbletv.follows_service.business.converters.FollowingConverter;
import com.pibbletv.follows_service.business.interfaces.FollowingService;
import com.pibbletv.follows_service.domain.Following;
import com.pibbletv.follows_service.persistance.entities.FollowingEntity;
import com.pibbletv.follows_service.persistance.repository.FollowingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class FollowingServiceImpl implements FollowingService {
    private final FollowingRepository followingRepository;

    @Override
    public Mono<Void> followUser(Following following) {
        return followingRepository.save(FollowingConverter.convertToEntity(following))
                .then();
    }

    @Override
    public Mono<Void> unfollowUser(Following following) {
        return followingRepository.delete(FollowingConverter.convertToEntity(following))
                .then();
    }

    @Override
    public Flux<Following> getFollowers(String userId) {
        return followingRepository.findByFollowedId(userId)
                .map(FollowingConverter::convertToObject);
    }

    @Override
    public Flux<Following> getFollowing(String userId) {
        return followingRepository.findByFollowerId(userId)
                .map(FollowingConverter::convertToObject);
    }
}
