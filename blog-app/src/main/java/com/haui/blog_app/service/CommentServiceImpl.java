package com.haui.blog_app.service;

import com.haui.blog_app.Repository.CommentRepository;
import com.haui.blog_app.dto.CommentDto;
import com.haui.blog_app.entity.Comment;
import com.haui.blog_app.form.CommentCreateForm;
import com.haui.blog_app.form.CommentUpdateForm;
import com.haui.blog_app.mapper.CommentMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Override
    public Page<CommentDto> findALl(Pageable pageable){
        return commentRepository.findAll(pageable)
                .map(CommentMapper::map);
    }

    @Override
    public CommentDto findById(Long id){
        return commentRepository.findById(id)
                .map(CommentMapper::map)
                .orElse(null);
    }

    @Override
    public CommentDto create(CommentCreateForm form){
        var comment = CommentMapper.map(form);
        var saveComment = commentRepository.save(comment);
        return CommentMapper.map(saveComment);
    }

    @Override
    public CommentDto update(CommentUpdateForm form, Long id){
        var optional = commentRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }
        var comment = optional.get();
        CommentMapper.map(form, comment);
        var savedComment = commentRepository.save(comment);
        return CommentMapper.map(savedComment);
    }

    @Override
    public void deleteById(Long id){
        commentRepository.deleteById(id);
    }
}
