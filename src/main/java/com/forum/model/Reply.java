package com.forum.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reply extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name="comment_id")
    @JsonBackReference
    private Comment comment;

    @OneToMany
    @JoinColumn(name = "reply_id")
    @JsonBackReference
    private List<Reply> replyList;

    private String text;


}
