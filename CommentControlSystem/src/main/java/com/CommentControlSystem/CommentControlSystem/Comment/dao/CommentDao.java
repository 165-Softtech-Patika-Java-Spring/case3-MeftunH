package com.CommentControlSystem.CommentControlSystem.Comment.dao;

import com.CommentControlSystem.CommentControlSystem.Comment.dto.CommentDto;
import com.CommentControlSystem.CommentControlSystem.Comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {
    public List<Comment> findByUserId(Long userId);
    public List<Comment> findByProductId(Long productId);
}
