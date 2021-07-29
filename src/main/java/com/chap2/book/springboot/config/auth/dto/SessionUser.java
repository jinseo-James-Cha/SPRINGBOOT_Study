package com.chap2.book.springboot.config.auth.dto;

import com.chap2.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

// 세션에 저장하기 위해 직렬화를 구현한 클래스를 생성
// @Entity의 클래스는 다른 엔티티와의 관계가 형성 될 가능성이 있고
// 이것은 성능 이슈, 부수 효과가 발생할 확률이 높다.
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
