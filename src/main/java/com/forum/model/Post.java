package com.forum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Post extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    @OneToMany(mappedBy = "post")
    private List<Comment> commentList;
}
