package com.back.domain.post.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // 아래 구조대로 DB 테이블(컬럼)을 만들어야 한다.
public class Post {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private int id; // INT
    private String title; // VARCHAR(255)
    @Column(columnDefinition = "TEXT")
    private String content; // TEXT
}

