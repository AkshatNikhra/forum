package com.forum.controller;

import com.forum.dtos.ReplyReqDto;
import com.forum.dtos.ReplyResDto;
import com.forum.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @PostMapping
    ResponseEntity<ReplyResDto> createNewReply(@RequestBody ReplyReqDto replyReqDto){
        ReplyResDto replyResDto = replyService.createNewReply(replyReqDto);
        return new ResponseEntity<>(replyResDto, HttpStatus.CREATED);
    }
    @GetMapping("/{commentId}")
    ResponseEntity<List<ReplyResDto>> getAllReplyOnComment(@PathVariable Long commentId){
        List<ReplyResDto> replyResDto = replyService.getAllReplyOnComment(commentId);
        return new ResponseEntity<>(replyResDto, HttpStatus.CREATED);
    }
}
