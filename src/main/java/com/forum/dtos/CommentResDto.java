package com.forum.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResDto {
    private UserResDto userResDto;
    private PostResDto postResDto;
    private String text;
}
