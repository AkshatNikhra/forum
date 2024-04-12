package com.forum.service;

import com.forum.dtos.CommentReqDto;
import com.forum.dtos.CommentResDto;

import java.util.List;

public interface CommentService {
    public CommentResDto createNewCommentOnPost(CommentReqDto commentReqDto);
    public List<CommentResDto> getAllCommentOnPost(Long postId);
}
