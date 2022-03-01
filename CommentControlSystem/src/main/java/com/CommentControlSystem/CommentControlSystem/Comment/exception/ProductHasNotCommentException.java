package com.CommentControlSystem.CommentControlSystem.Comment.exception;

public class ProductHasNotCommentException extends Exception {

    private int errorCode;
    private String errorMessage;

    public ProductHasNotCommentException(Throwable throwable) {
        super(throwable);
    }

    public ProductHasNotCommentException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public ProductHasNotCommentException(String msg) {
        super(msg);
    }

    public ProductHasNotCommentException(String message, int errorCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = message;
    }


    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return this.errorCode + " : " + this.getErrorMessage();
    }
}