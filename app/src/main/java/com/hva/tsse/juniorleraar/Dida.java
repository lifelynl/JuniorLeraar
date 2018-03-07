package com.hva.tsse.juniorleraar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.hva.tsse.juniorleraar.adapter.DialogueCardAdapter;
import com.hva.tsse.juniorleraar.firebase.DataSource;
import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 15-2-2018.
 */

public class Dida extends AppCompatActivity {

    private ListView list_didactisch_bekwaam;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dida);
        this.setTitle("Didactisch bekwaam");

        list_didactisch_bekwaam = (ListView) findViewById(R.id.list_didactisch_bekwaam);

        List<DialogueCard> mDialogueCards = new ArrayList<>();
        DataSource data = new DataSource();
        mDialogueCards = data.getTitlesDidactischBekwaam();

        // set adapter
        final DialogueCardAdapter adapter = new DialogueCardAdapter(this, mDialogueCards);
        list_didactisch_bekwaam.setAdapter(adapter);
    }



}
