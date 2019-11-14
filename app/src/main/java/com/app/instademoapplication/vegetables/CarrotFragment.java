package com.app.instademoapplication.vegetables;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.instademoapplication.BaseFragment;
import com.app.instademoapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarrotFragment extends BaseFragment {
    public static final String TAG = CarrotFragment.class.getSimpleName();


    public static CarrotFragment newInstance() {
        return new CarrotFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carrot, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        (v.findViewById(R.id.tv_title)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "No vegetable available", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public String getTAG() {
        return TAG;
    }

}
