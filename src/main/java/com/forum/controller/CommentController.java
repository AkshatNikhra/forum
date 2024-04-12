package com.forum.controller;

import com.forum.dtos.CommentReqDto;
import com.forum.dtos.CommentResDto;
import com.forum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/post")
    ResponseEntity<CommentResDto> createNewCommentOnPost(@RequestBody CommentReqDto commentReqDto){
        CommentResDto commentResDto = commentService.createNewCommentOnPost(commentReqDto);
        return new ResponseEntity<>(commentResDto, HttpStatus.CREATED);
    }
    @GetMapping("/post/{postId}")
    ResponseEntity<List<CommentResDto>> getAllCommentOnPost(@PathVariable Long postId){
        List<CommentResDto> commentResDtos = commentService.getAllCommentOnPost(postId);
        return new ResponseEntity<>(commentResDtos, HttpStatus.OK);
    }

}
