package com.forum.controller;


import com.forum.dtos.PostResDto;
import com.forum.dtos.UserReqDto;
import com.forum.dtos.UserResDto;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    ResponseEntity<List<PostResDto>> getAllPostMadeByUser(@PathVariable Long id){
        List<PostResDto> postResDtoList = userService.getAllPostMadeByUser(id);
        return new ResponseEntity<>(postResDtoList, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<UserResDto> createNewUser(@RequestBody UserReqDto userReqDto){
        UserResDto userResDto = userService.createNewUser(userReqDto);
        return new ResponseEntity<>(userResDto, HttpStatus.CREATED);
    }
}
