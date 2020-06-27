package com.rohit.fragment_activity_fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {

    private static final String TAG = "Communication";
    public static final String FRAGMENT_TAG = "output_fragment_tag";
    private FloatingActionButton floatingActionButton;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.fab);
        show();
        output();
    }

    private void show() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainFragment mainFragment = new MainFragment();
                getFragmentManager().beginTransaction().add(R.id.device_fragment, mainFragment).commit();
                output();
            }
        });
    }

    private void output() {
        OutPutFragment outPutFragment = new OutPutFragment();
        getFragmentManager().beginTransaction().add(R.id.out_fragment, outPutFragment, FRAGMENT_TAG).commit();
    }

    @Override
    public void onFragmentInteraction(Person person) {
        OutPutFragment outPutFragment = (OutPutFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        outPutFragment.displayOutputFragment(person);
        Log.d(TAG, "onFragmentInteraction: person " + person.toString());

    }


}
