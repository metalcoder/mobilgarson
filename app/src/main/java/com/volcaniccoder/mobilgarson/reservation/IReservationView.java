package com.volcaniccoder.mobilgarson.reservation;

import com.volcaniccoder.mobilgarson.models.pojo.TableResult;

import java.util.List;

/**
 * Created by volkan.sahin on 7.01.2017.
 */

public interface IReservationView {

    void listRestaurants(List<TableResult> tableResults);

    void error();
}
