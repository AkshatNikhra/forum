package com.forum.controller;

import com.forum.dtos.PostReqDto;
import com.forum.dtos.PostResDto;
import com.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @PostMapping
    ResponseEntity<PostResDto> createNewPost(@RequestBody PostReqDto postReqDto){
        PostResDto postResDto = postService.createNewPost(postReqDto);

        return new ResponseEntity<>(postResDto, HttpStatus.CREATED);
    }
}
