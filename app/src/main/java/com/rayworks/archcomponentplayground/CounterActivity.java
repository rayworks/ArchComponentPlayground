package com.rayworks.archcomponentplayground;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class CounterActivity extends TrackableActivity {

    public static final String PLACE_HOLDER = "place_holder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(PLACE_HOLDER);
        if (fragment == null) {
            fragment = new CounterFragment();

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_parent, fragment, PLACE_HOLDER)
                    .commit();
        } else {
            System.out.println(">>> Fragment found " + fragment.toString());
        }
    }

}
