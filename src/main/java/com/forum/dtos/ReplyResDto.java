package com.forum.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyResDto {
    private UserResDto user;
    private CommentResDto commentResDto;
    private Long replyId;
    private String text;
}
