package com.CommentControlSystem.CommentControlSystem.Comment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CommentDto {
    private Long id;
    private Long productId;
    private Long userId;
    private String title;
    private String content;
}
