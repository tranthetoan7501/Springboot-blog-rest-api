package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.ParamSearch;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class IPostSearchRepoImpl implements IPostSearchRepo{
    private final EntityManager entityManager;
    private final PostRepository postRepository;

    public IPostSearchRepoImpl(EntityManager entityManager,@Lazy PostRepository postRepository) {
        this.entityManager = entityManager;
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> searchPost(ParamSearch paramSearch) {
        Specification <Post> specification =Specification.where(null);
        if(paramSearch.getTitle()!=null){
            specification=specification.and((Specification<Post>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"),"%"+paramSearch.getTitle()+"%"));
        }
        if(paramSearch.getDescription()!=null){
            specification=specification.and((Specification<Post>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("description"),"%"+paramSearch.getDescription()+"%"));
        }
        if(paramSearch.getContent()!=null){
            specification=specification.and((Specification<Post>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("content"),"%"+paramSearch.getContent()+"%"));
        }
       return postRepository.findAll(specification);

    }
}
