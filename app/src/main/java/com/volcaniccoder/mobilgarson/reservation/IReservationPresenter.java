package com.volcaniccoder.mobilgarson.reservation;

/**
 * Created by volkan.sahin on 7.01.2017.
 */

public interface IReservationPresenter {
    void getTables();

    void createReservation(long restaurantId, String date, String clock, long userId,
                           String name, String surname, long tableId);
}
