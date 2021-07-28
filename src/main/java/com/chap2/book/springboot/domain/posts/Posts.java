package com.chap2.book.springboot.domain.posts;

import com.chap2.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 필드의 모든 getter method생성, lombok annotation, optional
@NoArgsConstructor // 기본생성자추가, lombot annotation, optional
@Entity // JPA annotation, mandatory
public class Posts extends BaseTimeEntity {

    @Id // 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 적용
    private Long id; // Long 타입을 추천 -> mysql에서는 bigint 타입

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성
             // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 더티 체킹을 위한 값 변경 메소드
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
