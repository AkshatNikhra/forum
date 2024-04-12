package com.forum.model;

import com.forum.dtos.CommentReqDto;
import com.forum.dtos.CommentResDto;
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

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment")
    @Cascade(CascadeType.ALL)
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
        commentResDto.setPostResDto(Post.getPostResDtoFromPost(comment.getPost()));
        commentResDto.setText(comment.getText());
        commentResDto.setUserResDto(User.getResDtoFromUser(comment.getUser()));
        return commentResDto;
    }

}
