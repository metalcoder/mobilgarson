package com.volcaniccoder.mobilgarson.restaurant.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.table.TableActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.buttonCallWaiter)
    Button btnCallWaiter;
    @BindView(R.id.buttonCallPrice)
    Button btnCallPrice;
    @BindView(R.id.buttonReservation)
    Button btnReservation;
    @BindView(R.id.buttonChooseTable)
    Button buttonChooseTable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vİew = inflater.inflate(R.layout.fragment_restaurant, container, false);
        ButterKnife.bind(this, vİew);

        btnCallWaiter.setOnClickListener(this);
        btnCallPrice.setOnClickListener(this);
        btnReservation.setOnClickListener(this);
        buttonChooseTable.setOnClickListener(this);

        return vİew;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCallWaiter:
                Toast.makeText(getContext(), "buttonCallWaiter", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonCallPrice:
                Toast.makeText(getContext(), "buttonCallPrice", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonReservation:
                Toast.makeText(getContext(), "buttonReservation", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonChooseTable:
                Toast.makeText(getContext(), "buttonChooseTable", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), TableActivity.class));
                break;
        }
    }
}
