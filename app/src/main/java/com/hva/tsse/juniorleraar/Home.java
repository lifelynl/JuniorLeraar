package com.hva.tsse.juniorleraar;

<<<<<<< HEAD
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.hva.tsse.juniorleraar.firebase.Firebase;
import com.hva.tsse.juniorleraar.model.DialogueCard;

=======
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
>>>>>>> development
import java.util.List;

public class Home extends AppCompatActivity {

<<<<<<< HEAD
    private static final String TAG = "HOMECLASS";
    private Firebase mFirebase;
    private List<DialogueCard> mDialogueCards;
=======
    // Vars
    private Button mDida;
    private Button mColle;
    private Button mPeda;
>>>>>>> development

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
<<<<<<< HEAD
        mFirebase = new Firebase();
        while (mDialogueCards.size() > 0) {
            mFirebase.getData();

            mDialogueCards = mFirebase.getmDialogueCards();
            if(mDialogueCards.size() > 0) {
                TextView text;
                text = (TextView) findViewById(R.id.textview);

                Log.w(TAG, "Value3: " + mDialogueCards.size());
            }
        }
=======


        // findViews
        Button mDidaBtn = (Button)findViewById(R.id.btn_didactisch);
        Button mColleBtn = (Button)findViewById(R.id.btn_collegiaal);
        Button mPedaBtn = (Button)findViewById(R.id.btn_pedagogisch);


        // Nav
        mDidaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent didaIntent = new Intent(Home.this, Dida.class);
                    Home.this.startActivity(didaIntent);
            }
        });

        mColleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colleIntent = new Intent(Home.this, Colle.class);
                Home.this.startActivity(colleIntent);
            }
        });

        mPedaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pedaIntent = new Intent(Home.this, Peda.class);
                Home.this.startActivity(pedaIntent);
            }
        });


//        Toolbar toolbar = (Toolbar)findViewById(R.id.main_toolbar);
//        setToolbar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//        getSupportActionBar().setElevation(0);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setToolbar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
>>>>>>> development
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_settings: {
//                showSettingsActivity(false);
//                return true;
//            }
//            case android.R.id.home: {
//                onBackPressed();
//                return true;
//            }
//            default: {
//                return false;
//            }
//        }
//    }
}
