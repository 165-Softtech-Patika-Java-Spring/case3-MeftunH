package com.CommentControlSystem.CommentControlSystem.Comment.exception;

public class ProductHasNotCommentResponse {

    private String error;

    public ProductHasNotCommentResponse() {

    }

    public ProductHasNotCommentResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}