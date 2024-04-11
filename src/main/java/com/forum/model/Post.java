package com.forum.model;

import com.forum.dtos.PostReqDto;
import com.forum.dtos.PostResDto;
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
public class Post extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    @OneToMany(mappedBy = "post")
    @Cascade(CascadeType.ALL)
    private List<Comment> commentList;

    public static List<PostResDto> findPostResDtoFromPost(List<Post> postList){
        List<PostResDto> postResDtoList = new ArrayList<>();
        for(Post post:postList){
            postResDtoList.add(getPostResDtoFromPost(post));
        }
        return postResDtoList;
    }

    public static Post getPostFromPostReqDto(PostReqDto postReqDto, User user){
        Post post = new Post();
        post.setUser(user);
        post.setText(postReqDto.getText());
        return post;
    }
    public static PostResDto getPostResDtoFromPost(Post post){
        PostResDto postResDto = new PostResDto();
        postResDto.setUserResDto(User.getResDtoFromUser(post.getUser()));
        postResDto.setText(post.getText());
        return postResDto;
    }

}
