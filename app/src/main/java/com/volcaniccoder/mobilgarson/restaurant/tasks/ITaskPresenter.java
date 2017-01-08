package com.volcaniccoder.mobilgarson.restaurant.tasks;

/**
 * Created by volkan.sahin on 7.01.2017.
 */

public interface ITaskPresenter {

    void getWaiterList();

    void createRequest(long userId,long restId,long garsonId);

    void getBill();
}
