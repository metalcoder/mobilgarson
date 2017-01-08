package com.volcaniccoder.mobilgarson.reservation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.adapters.DashboardAdapter;
import com.volcaniccoder.mobilgarson.login.LoginPresenterImpl;
import com.volcaniccoder.mobilgarson.models.pojo.TableResult;
import com.volcaniccoder.mobilgarson.table.TablePresenterImpl;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReservationActivity extends AppCompatActivity implements IReservationView, View.OnClickListener {

    @BindView(R.id.reservationName)
    EditText reservationName;
    @BindView(R.id.reservationSurname)
    EditText reservationSurname;
    @BindView(R.id.reservationDate)
    TextView reservationDate;
    @BindView(R.id.reservationClock)
    TextView reservationClock;
    @BindView(R.id.reservationTable)
    TextView reservationTable;
    @BindView(R.id.reservationButton)
    Button reservationButton;

    IReservationPresenter presenter;

    private AlertDialog.Builder builder;
    private TableResult selectedTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        ButterKnife.bind(this);
        init();
    }

    public void init() {
        presenter = new ReservationPresenterImpl(this, ((MobilGarsonApp) getApplication()));
        reservationDate.setOnClickListener(this);
        reservationClock.setOnClickListener(this);
        reservationTable.setOnClickListener(this);
        reservationButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reservationDate:
                Calendar c = Calendar.getInstance();
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Toast.makeText(ReservationActivity.this, "" + monthOfYear + "-" + dayOfMonth, Toast.LENGTH_SHORT).show();
                        reservationDate.setText("" + dayOfMonth + "." + (monthOfYear + 1) + "." + year);
                        reservationDate.setText(String.format("%02d/%02d", dayOfMonth, (monthOfYear + 1)) + "/" + year);
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.reservationClock:
                new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(ReservationActivity.this, "" + hourOfDay + "-" + minute, Toast.LENGTH_SHORT).show();
                        reservationClock.setText(String.format("%02d:%02d", hourOfDay, minute));
                    }
                }, 12, 00, true).show();
                break;
            case R.id.reservationTable:
                builder = new AlertDialog.Builder(this);
                presenter.getTables();
                break;
            case R.id.reservationButton:
                presenter.createReservation(DashboardAdapter.restaurantId, reservationDate.getText().toString(),
                        reservationClock.getText().toString(), LoginPresenterImpl.userId, reservationName.getText().toString(),
                        reservationSurname.getText().toString(), selectedTable.getId());
                break;
        }
    }


    @Override
    public void listRestaurants(final List<TableResult> tableResults) {
        int counter = 0;
        final String[] tableNames = new String[tableResults.size()];
        for (TableResult tableResult : tableResults) {
            String name = tableResult.getName() + " Kapasite: " + tableResult.getCapacity();
            tableNames[counter] = name;
            counter++;
        }
        builder.setTitle("Masa Seçimi");
        builder.setSingleChoiceItems(tableNames, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedTable = tableResults.get(which);
                reservationTable.setText(selectedTable.getName() + " (Kapasite : " + selectedTable.getCapacity() + ")");
            }
        });

        builder.setPositiveButton("Seç", null);
        builder.create().show();
    }

    @Override
    public void error() {

    }
}
