package com.volcaniccoder.mobilgarson.restaurant.tasks;

import com.volcaniccoder.mobilgarson.models.pojo.BillResult;
import com.volcaniccoder.mobilgarson.models.pojo.EmployeeResult;

import java.util.List;

/**
 * Created by volkan.sahin on 7.01.2017.
 */

public interface ITaskView {

    void messageWaiter();

    void error();

    void showWaiterList(List<EmployeeResult> employeeResults);

    void showBillResult(BillResult bill);

    void tableNotChoosedError();
}
