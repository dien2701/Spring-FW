package com.haui.blog_app.service;

import com.haui.blog_app.PostRepository.PostRepository;
import com.haui.blog_app.dto.PostDto;
import com.haui.blog_app.entity.Post;
import com.haui.blog_app.form.PostCreateForm;
import com.haui.blog_app.form.PostUpdateForm;
import com.haui.blog_app.mapper.PostMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    @Override
    public List<PostDto> findAll(){
        var posts = postRepository.findAll();
        var dtos = new ArrayList<PostDto>();
        for(Post post : posts){
            var dto = PostMapper.map(post);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public PostDto findById(Long id){
        return postRepository.findById(id).map(PostMapper::map).orElse(null);
    }

    @Override
    public PostDto create(PostCreateForm form){
        var post = PostMapper.map(form);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public PostDto update(PostUpdateForm form, Long id){
        var optional = postRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }
        var post = optional.get();
        PostMapper.map(form, post);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public void deleteById(Long id){
        postRepository.deleteById(id);
    }
}


