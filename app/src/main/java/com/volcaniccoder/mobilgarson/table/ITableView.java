package com.volcaniccoder.mobilgarson.table;

import com.volcaniccoder.mobilgarson.models.pojo.TableResult;

import java.util.List;

/**
 * Created by volkan.sahin on 21.12.2016.
 */

public interface ITableView {

    void listRestaurants(List<TableResult> tablesList);

    void error();

    void tableChoosen();
}
