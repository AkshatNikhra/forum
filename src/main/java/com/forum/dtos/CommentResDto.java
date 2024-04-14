package com.forum.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommentResDto {
    private UserResDto userResDto;
    private Long commentId;
    private List<ReplyResDto> replyResDto;
    private String text;
}
