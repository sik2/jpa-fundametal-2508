package com.back.domain.post.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@Entity // 아래 구조대로 DB 테이블(컬럼)을 만들어야 한다.
@ToString
public class Post {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private final int id; // INT
    private final String title; // VARCHAR(255)
    @Column(columnDefinition = "TEXT")
    private final String content; // TEXT


    public Post (String title, String content) {
        this.id = 0;
        this.title = title;
        this.content = content;
    }

    public Post() {
        this("", "");
    }
}

