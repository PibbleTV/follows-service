package com.pibbletv.follows_service.business.interfaces;

import com.pibbletv.follows_service.domain.Following;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FollowingService {

    Mono<Void> followUser(Following following);

    Mono<Void> unfollowUser(Following following);

    Flux<Following> getFollowers(String userId);

    Flux<Following> getFollowing(String userId);


}
