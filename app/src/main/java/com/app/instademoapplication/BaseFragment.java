package com.app.instademoapplication;


import androidx.fragment.app.Fragment;

import com.app.instademoapplication.backpresscontroller.BackPressImpl;
import com.app.instademoapplication.backpresscontroller.OnBackPressListener;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment implements OnBackPressListener {


    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public boolean onBackPressed() {
        return new BackPressImpl(this).onBackPressed();
    }

    // in BaseFragment
    public abstract String getTAG();
}
