package com.jojoldu.book.springboot.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface PostsRepository extends JpaRepository<Posts,Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") //@query가 가독성이 더 좋다.
    List<Posts> findAllDesc();
}
