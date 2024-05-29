package com.pet.spring.domain.user.entity;

import com.pet.spring.domain.BaseEntity;
import com.pet.spring.domain.comment.entity.Comment;
import com.pet.spring.domain.feed.enitty.Feed;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity()
public class User extends BaseEntity {
    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Column(length = 10, nullable = false)
    private String username;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String profileImage;

    @Column(length = 255)
    private String token;

    @Column(length = 100)
    private String introduction;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Feed> feeds;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;
}
