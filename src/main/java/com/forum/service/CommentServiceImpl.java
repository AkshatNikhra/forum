package com.forum.service;

import com.forum.dtos.CommentReqDto;
import com.forum.dtos.CommentResDto;
import com.forum.model.Comment;
import com.forum.model.Post;
import com.forum.model.User;
import com.forum.repository.PostRepo;
import com.forum.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostRepo postRepo;
    @Override
    public CommentResDto createNewCommentOnPost(CommentReqDto commentReqDto) {
        User user = userRepo.findById(commentReqDto.getUserId()).get();
        Post post = postRepo.findById(commentReqDto.getPostId()).get();

        Comment comment = Comment.getCommentFromCommentReqDto(user, post, commentReqDto);
        List<Comment> commentList = post.getCommentList();
        commentList.add(comment);
        post.setCommentList(commentList);
        post = postRepo.save(post);
        CommentResDto commentResDto = new CommentResDto();
        commentResDto.setPostResDto(Post.getPostResDtoFromPost(post));
        commentResDto.setText(comment.getText());
        commentResDto.setUserResDto(User.getResDtoFromUser(user));
        return commentResDto;
    }

    @Override
    public List<CommentResDto> getAllCommentOnPost(Long postId) {
        Post post = postRepo.findById(postId).get();
        List<Comment> commentList = post.getCommentList();
        List<CommentResDto> commentResDtos = new ArrayList<>();
        for(Comment comment:commentList){
            commentResDtos.add(Comment.getCommentResDtoFromComment(comment));
        }
        return commentResDtos;
    }
}
