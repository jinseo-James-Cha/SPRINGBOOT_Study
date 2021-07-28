package com.chap2.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 반드시 @Entity Posts클래스와 같이 움직여야 함
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
