package com.app.instademoapplication.fruits;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.instademoapplication.BaseFragment;
import com.app.instademoapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FruitFragment extends BaseFragment {
    public static final String TAG = FruitFragment.class.getSimpleName();

    public static FruitFragment newInstance() {
        return new FruitFragment();
    }

    public FruitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fruit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        (v.findViewById(R.id.tv_title)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getChildFragmentManager().beginTransaction()
                        .add(R.id.fl_container,AppleFragment.newInstance())
                        .addToBackStack("FruitFragment")
                        .commit();

            }
        });

    }

    @Override
    public String getTAG() {
        return TAG;
    }
}
