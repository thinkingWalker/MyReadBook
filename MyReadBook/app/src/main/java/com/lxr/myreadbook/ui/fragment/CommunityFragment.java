package com.lxr.myreadbook.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 2017/3/1  13:12
 *
 * @desc
 */

public class CommunityFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView=new TextView(getContext());
        textView.setText("nihao");
        textView.setTextSize(30);
        return textView;
    }
}
