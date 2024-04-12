package com.forum.service;

import com.forum.dtos.PostReqDto;
import com.forum.dtos.PostResDto;
import com.forum.model.Post;
import com.forum.model.User;
import com.forum.repository.PostRepo;
import com.forum.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostSeriveImpl implements PostService{

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;
    @Override
    public PostResDto createNewPost(PostReqDto postReqDto) {
        User user = userRepo.findById(postReqDto.getUserId()).get();
        Post post = Post.getPostFromPostReqDto(postReqDto, user);
        post = postRepo.save(post);
        return Post.getPostResDtoFromPost(post);
    }
}
