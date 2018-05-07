package com.hva.tsse.juniorleraar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hva.tsse.juniorleraar.adapter.DialogueCardAdapter;
import com.hva.tsse.juniorleraar.data.DataSource;
import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 15-2-2018.
 */

public class Peda extends AppCompatActivity {

    private ListView list_pedagogisch_bekwaam;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peda);

        ColorUtils.darkenStatusBar(this, R.color.colorPedagogisch);
        this.setTitle("Pedagogisch Bekwaam");

        list_pedagogisch_bekwaam = (ListView) findViewById(R.id.list_pedagogisch_bekwaam);

        List<DialogueCard> mDialogueCards = new ArrayList<>();
        DataSource data = new DataSource();
        mDialogueCards = data.getTitlesPedagogischBekwaam();

        // set adapter
        final DialogueCardAdapter adapter = new DialogueCardAdapter(this, mDialogueCards);
        list_pedagogisch_bekwaam.setAdapter(adapter);

        list_pedagogisch_bekwaam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Peda.this, TabActivity.class);
                DialogueCard selectedCard = adapter.getItem(position);
                intent.putExtra("selectedCard", selectedCard);
                Peda.this.startActivity(intent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });
    }
}
