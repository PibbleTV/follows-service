
package com.pibbletv.follows_service.persistance.entities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("user_following")
public class FollowingEntity {

    @Id
    private Long id;

    @NotNull
    @Column("followerId")
    private UUID followerId;

    @NotNull
    @Column("followedId")
    private UUID followedId;
}