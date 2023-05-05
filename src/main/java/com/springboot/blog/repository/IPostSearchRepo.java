package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.ParamSearch;

import java.util.List;

public interface IPostSearchRepo {
    List<Post> searchPost(ParamSearch paramSearch);
}
