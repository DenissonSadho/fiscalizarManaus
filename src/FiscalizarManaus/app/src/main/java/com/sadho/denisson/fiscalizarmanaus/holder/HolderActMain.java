package com.sadho.denisson.fiscalizarmanaus.holder;

import android.widget.ImageButton;

import com.sadho.denisson.fiscalizarmanaus.R;
import com.sadho.denisson.fiscalizarmanaus.activities.IViewMainAct;

public class HolderActMain {

    private ImageButton mIBBusStop;

    private IViewMainAct mView;

    public HolderActMain(final IViewMainAct view) {
        mView = view;
        initialize();
    }

    public void initialize() {
        mIBBusStop = (ImageButton) mView.findViewById(R.id.ib_bus_stop);
    }

    public ImageButton getIBBusStop() {
        return mIBBusStop;
    }
}
