package com.CommentControlSystem.CommentControlSystem.Comment.exception;

public class UserHasNotCommentResponse {

    private String error;

    public UserHasNotCommentResponse() {

    }

    public UserHasNotCommentResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}