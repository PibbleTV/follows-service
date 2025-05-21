
package com.pibbletv.follows_service.persistance.entities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("user_following")
public class FollowingEntity {

    @Id
    @Column("id")
    private Long id;

    @NotNull
    @Column("followerId")
    private String followerId;

    @NotNull
    @Column("followedId")
    private String followedId;
}