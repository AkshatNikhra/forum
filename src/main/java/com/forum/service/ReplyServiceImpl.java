package com.forum.service;

import com.forum.dtos.CommentResDto;
import com.forum.dtos.ReplyReqDto;
import com.forum.dtos.ReplyResDto;
import com.forum.model.Comment;
import com.forum.model.Reply;
import com.forum.model.User;
import com.forum.repository.CommentRepo;
import com.forum.repository.ReplyRepo;
import com.forum.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ReplyRepo replyRepo;
    @Override
    public ReplyResDto createNewReply(ReplyReqDto replyReqDto) {
        User user = userRepo.findById(replyReqDto.getUserId()).get();
        Reply reply;
        ReplyResDto replyResDto = new ReplyResDto();
        replyResDto.setUser(User.getResDtoFromUser(user));
        if(replyReqDto.getCommentId() == null){
            Reply prevReply = replyRepo.findById(replyReqDto.getReplyId()).get();
            reply = new Reply();
            reply.setUser(user);
            reply.setText(replyReqDto.getText());
            List<Reply> replyList = prevReply.getReplyList();
            replyList.add(reply);
            reply = replyRepo.save(reply);
            replyResDto.setReplyId(prevReply.getId());
            replyResDto.setText(reply.getText());
            replyResDto.setReplyId(reply.getId());

        }else{
            Comment comment = commentRepo.findById(replyReqDto.getCommentId()).get();
            reply = new Reply();
            reply.setComment(comment);
            reply.setText(replyReqDto.getText());
            reply.setUser(user);
            List<Reply> replyList = comment.getReplyList();
            replyList.add(reply);
            commentRepo.save(comment);
            replyResDto.setText(reply.getText());
            replyResDto.setReplyId(reply.getId());
        }
        return replyResDto;
    }

    @Override
    public List<ReplyResDto> getAllReplyOnComment(Long commentId) {
        Comment comment = commentRepo.findById(commentId).get();
        List<Reply> replyList = comment.getReplyList();
        List<ReplyResDto> replyResDtoList = new ArrayList<>();
        for(Reply reply:replyList){
            ReplyResDto replyResDto = new ReplyResDto();
            replyResDto.setText(reply.getText());
            replyResDto.setUser(User.getResDtoFromUser(reply.getUser()));
            replyResDto.setReplyId(reply.getId());
            replyResDtoList.add(replyResDto);
        }
        return replyResDtoList;
    }
}
