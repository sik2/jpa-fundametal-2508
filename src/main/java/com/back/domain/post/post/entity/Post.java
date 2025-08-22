package com.back.domain.post.post.entity;

import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Entity // 아래 구조대로 DB 테이블(컬럼)을 만들어야 한다.
@ToString
public class Post extends BaseEntity {
    private String title; // VARCHAR(255)
    @Column(columnDefinition = "TEXT")
    private String content; // TEXT

    public Post(String title, String content) {
            this.title = title;
            this.content = content;
    }
}

