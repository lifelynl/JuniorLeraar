package com.hva.tsse.juniorleraar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hva.tsse.juniorleraar.adapter.DialogueCardAdapter;
import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.List;

/**
 * Created by Julian on 15-2-2018.
 */

public class Dida extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dida);
        this.setTitle("Didactisch bekwaam");

//        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        DialogueCardAdapter adapter = new DialogueCardAdapter();
        List<DialogueCard> list = adapter.getCardsDidactischBekwaamStartbekwaam();
        list = adapter.getCardsDidactischBekwaamStartbekwaam();
        list = adapter.getCardsCollegialeSamenwerkingBekwaam();
        list = adapter.getCardsCollegialeSamenwerkingStartbekwaam();
        list = adapter.getCardsDidactischBekwaamBekwaam();
        list = adapter.getCardsPedagogischBekwaamBekwaam();
        list = adapter.getCardsPedagogischBekwaamStartbekwaam();
    }



}
