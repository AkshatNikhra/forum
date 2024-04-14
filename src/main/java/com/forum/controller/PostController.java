package com.forum.controller;

import com.forum.dtos.PostReqDto;
import com.forum.dtos.PostResDto;
import com.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<PostResDto> createNewPost(@RequestBody PostReqDto postReqDto){
        PostResDto postResDto = postService.createNewPost(postReqDto);

        return new ResponseEntity<>(postResDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<PostResDto> getPostData(@PathVariable Long id){
        PostResDto postDataResDto = postService.getPostData(id);
        return new ResponseEntity<>(postDataResDto, HttpStatus.OK);
    }
}
