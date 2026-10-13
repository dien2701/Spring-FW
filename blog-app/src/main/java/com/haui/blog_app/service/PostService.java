package com.haui.blog_app.service;

import com.haui.blog_app.dto.PostDto;
import com.haui.blog_app.form.PostCreateForm;
import com.haui.blog_app.form.PostUpdateForm;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(Long id);

    PostDto create(PostCreateForm form);

    PostDto update(PostUpdateForm form, Long id);

    void deleteById(Long id);
}
