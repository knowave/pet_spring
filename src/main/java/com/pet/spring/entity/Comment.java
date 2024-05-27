package com.pet.spring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity()
public class Comment extends BaseEntity {
    @Column(length = 500, nullable = false)
    @NotEmpty(message = "댓글 내용을 입력해주세요.")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;
}
