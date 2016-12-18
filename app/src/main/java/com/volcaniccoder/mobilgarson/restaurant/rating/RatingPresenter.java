package com.volcaniccoder.mobilgarson.restaurant.rating;

import com.volcaniccoder.mobilgarson.models.CommentModel;

import java.util.ArrayList;
import java.util.List;

public class RatingPresenter implements IRatingPresenter {

    private IRatingView view;

    public RatingPresenter(IRatingView view) {
        this.view = view;
    }

    public List<CommentModel> getComments(){

        List<CommentModel> list = new ArrayList<>();
        list.add(new CommentModel("Harika bir restorant","17.12.2016"));
        list.add(new CommentModel("Yemekler gayet güzeldi , bir dahaki sefer yine oradayım","02.12.2016"));
        list.add(new CommentModel("Ben pek beğenmedim , hizmetleri fazla iyi değildi","21.11.2016"));

        return list;
    }
}
