package com.hva.tsse.juniorleraar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hva.tsse.juniorleraar.firebase.Firebase;

public class Home extends AppCompatActivity {

    private static final String TAG = "HOMECLASS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView text;
        text = (TextView)findViewById(R.id.textview);

        Firebase mFirebase = new Firebase();
        mFirebase.getData();
        mFirebase.getDialogueCards();
//        List<DialogueCard> mDialogueCards = mFirebase.getDialogueCards();
//        Log.w(TAG, "Value3: " + mDialogueCards.get(0).getLevel());
//        text.setText(mDialogueCards.toString());
    }
}
