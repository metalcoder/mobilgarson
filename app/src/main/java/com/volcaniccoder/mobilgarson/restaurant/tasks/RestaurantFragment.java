package com.volcaniccoder.mobilgarson.restaurant.tasks;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.adapters.DashboardAdapter;
import com.volcaniccoder.mobilgarson.login.LoginPresenterImpl;
import com.volcaniccoder.mobilgarson.models.pojo.BillResult;
import com.volcaniccoder.mobilgarson.models.pojo.EmployeeResult;
import com.volcaniccoder.mobilgarson.reservation.ReservationActivity;
import com.volcaniccoder.mobilgarson.table.TableActivity;
import com.volcaniccoder.mobilgarson.table.TablePresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantFragment extends Fragment implements ITaskView, View.OnClickListener {

    @BindView(R.id.buttonCallWaiter)
    Button btnCallWaiter;
    @BindView(R.id.buttonCallPrice)
    Button btnCallPrice;
    @BindView(R.id.buttonReservation)
    Button btnReservation;
    @BindView(R.id.buttonChooseTable)
    Button buttonChooseTable;

    ITaskPresenter presenter;

    AlertDialog.Builder builder;
    EmployeeResult employee;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    public void init() {
        presenter = new TaskPresenterImpl(this, ((MobilGarsonApp) (getActivity().getApplication())));
        btnCallWaiter.setOnClickListener(this);
        btnCallPrice.setOnClickListener(this);
        btnReservation.setOnClickListener(this);
        buttonChooseTable.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCallWaiter:
                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Garson Seçimi");
                Toast.makeText(getContext(), "buttonCallWaiter", Toast.LENGTH_SHORT).show();
                presenter.getWaiterList();
                break;
            case R.id.buttonCallPrice:
                presenter.getBill();
                Toast.makeText(getContext(), "buttonCallPrice", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonReservation:
                Toast.makeText(getContext(), "buttonReservation", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), ReservationActivity.class));
                break;
            case R.id.buttonChooseTable:
                Toast.makeText(getContext(), "buttonChooseTable", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), TableActivity.class));
                break;
        }
    }

    @Override
    public void messageWaiter() {
        Toast.makeText(getContext(), "Garson Çağırıldı", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error() {
        Toast.makeText(getContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showWaiterList(final List<EmployeeResult> employeeResults) {
        int counter = 0;
        employee = employeeResults.get(0);
        String[] names = new String[employeeResults.size()];
        for (EmployeeResult employeeRes : employeeResults) {
            names[counter] = employeeRes.getName()+ " " +employeeRes.getSurname();
            counter++;
        }
        builder.setSingleChoiceItems(names, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                employee = employeeResults.get(which);
            }
        });
        builder.setNegativeButton("İptal", null);
        builder.setPositiveButton("Çağır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.createRequest( LoginPresenterImpl.userId,
                        DashboardAdapter.restaurantId, employee.getId());
            }
        });
        builder.create().show();
    }

    @Override
    public void showBillResult(BillResult bill) {
        Toast.makeText(getContext(),"" + bill.getAmount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void tableNotChoosedError() {
        Toast.makeText(getContext(), "Önce bir masa seçmelisiniz", Toast.LENGTH_SHORT).show();
    }
}
