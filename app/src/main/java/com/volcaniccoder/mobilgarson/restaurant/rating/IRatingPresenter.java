package com.volcaniccoder.mobilgarson.restaurant.rating;


import com.volcaniccoder.mobilgarson.models.CommentModel;

import java.util.List;

public interface IRatingPresenter {

    List<CommentModel> getComments();
}
