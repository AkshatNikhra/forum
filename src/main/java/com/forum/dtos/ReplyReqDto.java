package com.forum.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyReqDto {
    private Long userId;
    private Long commentId;
    private Long replyId;
    private String text;
}
