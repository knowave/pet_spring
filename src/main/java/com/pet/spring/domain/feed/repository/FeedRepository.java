package com.pet.spring.domain.feed.repository;

import com.pet.spring.domain.feed.enitty.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
