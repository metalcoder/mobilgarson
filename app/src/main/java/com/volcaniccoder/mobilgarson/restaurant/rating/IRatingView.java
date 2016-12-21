package com.volcaniccoder.mobilgarson.restaurant.rating;

import com.volcaniccoder.mobilgarson.models.CommentModel;

import java.util.List;

public interface IRatingView {

    void listComments(List<CommentModel> comments);

    void error();

    void refreshComments();
}
