package com.CommentControlSystem.CommentControlSystem.Comment.dto;

import lombok.Data;

@Data
public class CommentSaveRequestDto {
    private Long productId;
    private Long userId;
    private String title;
    private String content;
}
