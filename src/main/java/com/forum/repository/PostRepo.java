package com.forum.repository;

import com.forum.model.Post;
import com.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends JpaRepository<Post, Long> {
    Optional<List<Post>> findAllByUser(User user);
}
