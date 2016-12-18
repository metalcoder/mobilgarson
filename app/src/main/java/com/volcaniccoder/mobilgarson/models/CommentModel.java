package com.volcaniccoder.mobilgarson.models;

public class CommentModel {

    private String comment;
    private String commentDate;

    public CommentModel(String comment, String commentDate) {
        this.comment = comment;
        this.commentDate = commentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
}
