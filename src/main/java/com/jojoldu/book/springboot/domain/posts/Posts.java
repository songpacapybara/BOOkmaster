package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column; //굳이 선언 안해도 해당 클래스의 필드는 모두 칼럼이 된다.
import javax.persistence.Entity; //테이블과 링크될 클래스 , 기본값으로 언더스코어 네이밍으로 테이블 이름을 매칭
import javax.persistence.GeneratedValue;  //PK의 생성규칙
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id //해당 테이블의 PK필드를 나타낸다
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition ="TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;

    }

}
