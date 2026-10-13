package com.haui.blog_app.controller;

import com.haui.blog_app.dto.PostDto;
import com.haui.blog_app.form.PostCreateForm;
import com.haui.blog_app.form.PostUpdateForm;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.haui.blog_app.service.PostService;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("/api/v1/posts")
    public List<PostDto> findAll(){
        return postService.findAll();
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostDto findById(@PathVariable("id") Long id){
        return postService.findById(id);
    }

    @PostMapping("/api/v1/posts")
    public PostDto create(@RequestBody PostCreateForm form){
        return postService.create(form);
    }

    @PutMapping("api/v1/posts/{id}")
    public PostDto update(@RequestBody PostUpdateForm form,
                          @PathVariable("id") Long id){
        return postService.update(form, id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") Long id){
        postService.deleteById(id);

    }

}
