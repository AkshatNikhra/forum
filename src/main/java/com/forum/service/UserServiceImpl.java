package com.forum.service;

import com.forum.dtos.PostResDto;
import com.forum.dtos.UserReqDto;
import com.forum.dtos.UserResDto;
import com.forum.model.Post;
import com.forum.model.User;
import com.forum.repository.PostRepo;
import com.forum.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    @Override
    public UserResDto createNewUser(UserReqDto userReqDto) {
        User user = User.getUserFromReqDto(userReqDto);
        user = userRepo.save(user);
        return User.getResDtoFromUser(user);
    }

    @Override
    public List<PostResDto> getAllPostMadeByUser(Long id) {
        User user = userRepo.findById(id).get();
        List<Post> postList = postRepo.findAllByUser(user).get();

        return Post.findPostResDtoFromPost(postList);
    }
}
