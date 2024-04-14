package com.forum.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.forum.dtos.CommentReqDto;
import com.forum.dtos.CommentResDto;
import com.forum.dtos.ReplyResDto;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;

    @OneToMany(mappedBy = "comment")
    @Cascade(CascadeType.ALL)
    @JsonManagedReference
    private List<Reply> replyList;

    private String text;

    public static Comment getCommentFromCommentReqDto(User user, Post post, CommentReqDto commentReqDto){
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setUser(user);
        comment.setText(commentReqDto.getText());
        return comment;
    }

    public static CommentResDto getCommentResDtoFromComment(Comment comment){
        CommentResDto commentResDto = new CommentResDto();
        commentResDto.setText(comment.getText());
        commentResDto.setCommentId(comment.getId());
        commentResDto.setUserResDto(User.getResDtoFromUser(comment.getUser()));
        List<ReplyResDto> replyResDtoList = new ArrayList<>();
        for(Reply reply: comment.replyList){
            ReplyResDto replyResDto = new ReplyResDto();
            replyResDto.setUser(replyResDto.getUser());
            replyResDto.setReplyId(reply.getId());
            replyResDto.setText(reply.getText());
        }
        return commentResDto;
    }

}
