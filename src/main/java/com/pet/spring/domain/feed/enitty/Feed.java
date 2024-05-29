package com.pet.spring.domain.feed.enitty;

import com.pet.spring.domain.BaseEntity;
import com.pet.spring.domain.comment.entity.Comment;
import com.pet.spring.domain.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

@Entity()
public class Feed extends BaseEntity {
    @Column(length = 50, nullable = false)
    @NotEmpty(message = "제목을 입력해주세요.")
    private String title;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String thumbnail;

    @Column(columnDefinition = "TEXT", nullable = false)
    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;
}
