package com.forum.controller;


import com.forum.dtos.PostResDto;
import com.forum.dtos.UserReqDto;
import com.forum.dtos.UserResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    ResponseEntity<List<PostResDto>> getAllPostMadeByUser(@PathVariable Long id){
        return null;
    }

    @PostMapping
    ResponseEntity<UserResDto> createNewUser(@RequestBody UserReqDto userReqDto){
        return null;
    }
}
