package com.forum.service;

import com.forum.dtos.PostResDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SearchService {
    void createIndex() throws InterruptedException;
    @Autowired
    List<PostResDto> getAllPosts(String searchQuery);
}
