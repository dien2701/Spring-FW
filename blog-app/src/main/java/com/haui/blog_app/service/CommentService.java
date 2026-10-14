package com.haui.blog_app.service;

import com.haui.blog_app.dto.CommentDto;
import com.haui.blog_app.form.CommentCreateForm;
import com.haui.blog_app.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    Page<CommentDto> findALl(Pageable pageable);

    CommentDto findById(Long id);

    CommentDto create(CommentCreateForm form);

    CommentDto update(CommentUpdateForm form, Long id);

    void deleteById(Long id);
}
