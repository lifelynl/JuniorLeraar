package com.hva.tsse.juniorleraar.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hva.tsse.juniorleraar.R;
import com.hva.tsse.juniorleraar.fragment.SearchFragment;

public class Startpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage2);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SearchFragment()).addToBackStack(null).commit();
    }
}
