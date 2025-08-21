package com.back.global.initData;


import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Configuration
public class BaseInitData {
    @Autowired
    @Lazy
    private BaseInitData self;

    private final PostService postService;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            self.work1();
            self.work2();
        };
    }

    @Transactional
    void work1() {
        if (postService.count() > 0) return;

        Post post1 = postService.save( new Post("제목 1", "내용 1"));
        // INSERT INTO post SET title = '제목 1';
        Post post2 = postService.save(new Post("제목 2", "내용 2"));
        // INSERT INTO post SET title = '제목 2';

        System.out.println("post1.getId() : " +  post1.getId());
        System.out.println("post2.getId() : " +  post2.getId());

        System.out.println("기본 데이터가 초기화 되었습니다.");
    }

    @Transactional(readOnly = true)
    void work2() {
        Optional<Post> opPost = postService.findById(1);
        // SELECT * FROM post WHERE id = 1;

        Post post = opPost.get();

        System.out.println("post : " + post);
    }
}
