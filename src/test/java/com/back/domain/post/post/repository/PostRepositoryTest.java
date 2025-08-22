package com.back.domain.post.post.repository;

import com.back.domain.post.post.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("2번 글 조회")
    void t1() {
        Post post2 = postRepository.findById(2).get();

        assertThat(post2.getTitle()).isEqualTo("제목 2");
        assertThat(post2.getContent()).isEqualTo("내용 2");
    }

    @Test
    @DisplayName("글 생성")
    void v2() {
        Post post = new Post("새 제목", "새 내용");
        Post createdPost = postRepository.save(post);

        assertThat(createdPost.getTitle()).isEqualTo("새 제목");
        assertThat(createdPost.getContent()).isEqualTo("새 내용");
    }
}
