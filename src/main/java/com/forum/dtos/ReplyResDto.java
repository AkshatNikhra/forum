package com.forum.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReplyResDto {
    private UserResDto user;
    private Long replyId;
    private List<ReplyResDto> replyResDtoList;
    private String text;
}
