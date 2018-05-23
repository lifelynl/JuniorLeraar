package com.hva.tsse.juniorleraar.Activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hva.tsse.juniorleraar.R;
import com.hva.tsse.juniorleraar.data.Json;
import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.List;

public class Home extends AppCompatActivity {

    // Vars
    private Button mDida;
    private Button mColle;
    private Button mPeda;
    private ImageView mInfo;

    private static boolean FIRSTRUN = true;
    private final String TAG = "HOMECLASS";
    private List<DialogueCard> mDialoguecards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        //Get JSON values from JSON file
        if (FIRSTRUN){
            Json json = new Json(this);
            FIRSTRUN = false;
        }

        // findViews
        Button mDidaBtn = (Button) findViewById(R.id.btn_didactisch);
        Button mColleBtn = (Button) findViewById(R.id.btn_collegiaal);
        Button mPedaBtn = (Button) findViewById(R.id.btn_pedagogisch);
        ImageView mInfo = (ImageView) findViewById(R.id.infoknop);

        // Nav
        mDidaBtn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.ECLAIR)
            @Override
            public void onClick(View v) {
                Intent didaIntent = new Intent(Home.this, Dida.class);
                Home.this.startActivity(didaIntent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        mColleBtn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.ECLAIR)
            @Override
            public void onClick(View v) {
                Intent colleIntent = new Intent(Home.this, Colle.class);
                Home.this.startActivity(colleIntent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        mPedaBtn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.ECLAIR)
            @Override
            public void onClick(View v) {
                Intent pedaIntent = new Intent(Home.this, Peda.class);
                Home.this.startActivity(pedaIntent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        mInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info = new Intent(Home.this, Info.class);
                Home.this.startActivity(info);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}
