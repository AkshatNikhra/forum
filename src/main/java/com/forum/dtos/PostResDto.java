package com.forum.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResDto {
    private UserResDto userResDto;
    private String text;
}
