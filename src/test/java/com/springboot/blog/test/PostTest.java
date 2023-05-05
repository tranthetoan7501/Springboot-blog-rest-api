package com.springboot.blog.test;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.ParamSearch;
import com.springboot.blog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    public void test(){
        ParamSearch paramSearch = new ParamSearch();
        paramSearch.setTitle("0 post");
        paramSearch.setDescription("0 post");
//        paramSearch.setContent("");

        List<Post> posts = postRepository.searchPost(paramSearch);
        for (Post post : posts) {
            System.out.println(post);
        }
    }
}
