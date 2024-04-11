package com.forum.model;

import com.forum.dtos.UserReqDto;
import com.forum.dtos.UserResDto;
import jakarta.persistence.Entity;
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
public class User extends BaseModel{
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    @Cascade(CascadeType.ALL)
    private List<Post> postList;

    public static User getUserFromReqDto(UserReqDto reqDto){
        User user = new User();
        user.setEmail(reqDto.getEmail());
        user.setName(reqDto.getName());
        return user;
    }

    public static UserResDto getResDtoFromUser(User user){
        UserResDto userResDto = new UserResDto();
        userResDto.setEmail(user.getEmail());
        userResDto.setId(user.getId());
        userResDto.setName(user.getName());
        return userResDto;
    }

}
