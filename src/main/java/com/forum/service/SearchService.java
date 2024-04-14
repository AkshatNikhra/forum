package com.forum.service;

import com.forum.dtos.PostResDto;
import com.forum.dtos.PostSearchResDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SearchService {
    void createIndex() throws InterruptedException;
    @Autowired
    List<PostSearchResDto> getAllPosts(String searchQuery);
}
