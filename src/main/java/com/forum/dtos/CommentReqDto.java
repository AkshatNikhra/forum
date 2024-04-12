package com.forum.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentReqDto {
    private Long userId;
    private Long postId;
    private String text;
}
