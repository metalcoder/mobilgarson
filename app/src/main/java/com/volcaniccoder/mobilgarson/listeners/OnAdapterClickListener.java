package com.volcaniccoder.mobilgarson.listeners;

import android.view.View;

public interface OnAdapterClickListener {

    void onClickAdapterListener(View view, int position);

    void onLongClickAdapterListener(View view, int position);
}
