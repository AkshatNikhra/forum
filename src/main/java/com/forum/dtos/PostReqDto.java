package com.forum.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostReqDto {
    private Long userId;
    private String text;
}
