package com.CommentControlSystem.CommentControlSystem.Comment.exception;

public class ProductHasNotComment extends Exception {

    private int errorCode;
    private String errorMessage;

    public ProductHasNotComment(Throwable throwable) {
        super(throwable);
    }

    public ProductHasNotComment(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public ProductHasNotComment(String msg) {
        super(msg);
    }

    public ProductHasNotComment(String message, int errorCode) {
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