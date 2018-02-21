package com.hva.tsse.juniorleraar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.hva.tsse.juniorleraar.firebase.Firebase;
import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.List;

public class Home extends AppCompatActivity {

    private static final String TAG = "HOMECLASS";
    private Firebase mFirebase;
    private List<DialogueCard> mDialogueCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
    }
}
