package com.pibbletv.follows_service.controller;

import com.pibbletv.follows_service.business.interfaces.FollowingService;
import com.pibbletv.follows_service.domain.Following;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/following")
@AllArgsConstructor
public class FollowingController {

    private FollowingService followingService;

    @PostMapping(value = "/followUser")
    public Mono<Void> followUser(@RequestBody Following following)
    {
        return followingService.followUser(following);
    }

    @DeleteMapping(value = "/unfollowUser")
    public Mono<Void> unfollowUser(@RequestBody Following following)
    {
        return followingService.unfollowUser(following);
    }

    @GetMapping(value = "/getFollowers")
    public Flux<Following> getFollowers(@RequestParam Long userId)
    {
        return followingService.getFollowers(userId);
    }

    @GetMapping(value = "/getFollowing")
    public Flux<Following> getFollowing(@RequestParam Long userId)
    {
        return followingService.getFollowing(userId);
    }
}
