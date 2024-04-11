package com.forum.service;

import com.forum.dtos.PostResDto;
import com.forum.dtos.UserReqDto;
import com.forum.dtos.UserResDto;

import java.util.List;

public interface UserService {
    public UserResDto createNewUser(UserReqDto userReqDto);
    public List<PostResDto> getAllPostMadeByUser(Long id);
}
