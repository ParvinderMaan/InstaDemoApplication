package com.app.instademoapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.app.instademoapplication.drinks.DrinkFragment;
import com.app.instademoapplication.fruits.FruitFragment;
import com.app.instademoapplication.vegetables.VegetableFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private FruitFragment mFruitFragment;
    private VegetableFragment mVegetableFragment;
    private DrinkFragment mDrinkFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.activity_main);

        mBottomNavigationView=findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(mBottomNavigationViewClickListener);


        // Note :show and hide fragments  { DrinkFragment ,FruitFragment ,VegetableFragment }

        mFruitFragment=FruitFragment.newInstance();
        mVegetableFragment=VegetableFragment.newInstance();
        mDrinkFragment=DrinkFragment.newInstance();

        // show FruitFragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl_container, mFruitFragment);
        ft.show(mFruitFragment);
        ft.commit();
    }






    private BottomNavigationView.OnNavigationItemSelectedListener mBottomNavigationViewClickListener=new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             //Note : you can create method for it .I am doing it just for simplicity
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            switch (item.getItemId()){

                case R.id.menu_fruits:
                    // show FruitFragment  / hide others
                    if (mFruitFragment.isAdded()) ft.show(mFruitFragment);
                    else ft.add(R.id.fl_container, mFruitFragment);
                    if (mVegetableFragment.isAdded())  ft.hide(mVegetableFragment);
                    if (mDrinkFragment.isAdded())  ft.hide(mDrinkFragment);
                    ft.commit();

                    break;

                case R.id.menu_veggies:
                    // show VegetableFragment / hide others
                    if (mVegetableFragment.isAdded()) ft.show(mVegetableFragment);
                    else ft.add(R.id.fl_container, mVegetableFragment);
                    if (mFruitFragment.isAdded())  ft.hide(mFruitFragment);
                    if (mDrinkFragment.isAdded())  ft.hide(mDrinkFragment);
                    ft.commit();

                    break;

                // show DrinkFragment  / hide others
                case R.id.menu_drinks:
                    if (mDrinkFragment.isAdded()) ft.show(mDrinkFragment);
                    else ft.add(R.id.fl_container, mDrinkFragment);
                    if (mFruitFragment.isAdded())  ft.hide(mFruitFragment);
                    if (mVegetableFragment.isAdded())  ft.hide(mVegetableFragment);
                    ft.commit();

                    break;
            }
            return true;
        }
    };


    // Note : take care of Toolbar presence
    protected void hideStatusBar() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    @Override
    public void onBackPressed() {

        if(!this.onBackPress()){
            super.onBackPressed();
        }

    }


    /**
     * Retrieve the currently visible  Fragment and propagate the onBackPressed callback
     *
     * @return true = if this fragment and/or one of its associates Fragment can handle the backPress
     */
    public boolean onBackPress() {

        switch (mBottomNavigationView.getSelectedItemId()){
            case R.id.menu_fruits:
                return mFruitFragment.onBackPressed();

            case R.id.menu_veggies:
                return mVegetableFragment.onBackPressed();

            case R.id.menu_drinks:
                return mDrinkFragment.onBackPressed();

        }


        // this Fragment couldn't handle the onBackPressed call
        return false;
    }
}
