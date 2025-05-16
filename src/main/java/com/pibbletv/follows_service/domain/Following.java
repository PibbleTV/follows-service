package com.pibbletv.follows_service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Following {

    private Long id;

    private UUID followerId;

    private UUID followedId;
}
