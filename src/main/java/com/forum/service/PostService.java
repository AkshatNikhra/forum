package com.forum.service;

import com.forum.dtos.PostReqDto;
import com.forum.dtos.PostResDto;

public interface PostService {
    public PostResDto createNewPost(PostReqDto postReqDto);
}
