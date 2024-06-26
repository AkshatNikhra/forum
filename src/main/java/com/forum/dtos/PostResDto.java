package com.forum.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostResDto {
    private UserResDto userResDto;
    private String text;
    private Long postId;
    private List<CommentResDto> commentResDtoList;
}
