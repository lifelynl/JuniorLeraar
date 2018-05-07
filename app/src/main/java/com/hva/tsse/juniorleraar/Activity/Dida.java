package com.hva.tsse.juniorleraar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hva.tsse.juniorleraar.ColorUtils;
import com.hva.tsse.juniorleraar.R;
import com.hva.tsse.juniorleraar.adapter.DialogueCardAdapter;
import com.hva.tsse.juniorleraar.data.DataSource;
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
        ColorUtils.darkenStatusBar(this, R.color.colorDidactisch);
        this.setTitle("Didactisch bekwaam");

        list_didactisch_bekwaam = (ListView) findViewById(R.id.list_didactisch_bekwaam);

        List<DialogueCard> mDialogueCards = new ArrayList<>();
        DataSource data = new DataSource();
        mDialogueCards = data.getTitlesDidactischBekwaam();

        // set adapter
        final DialogueCardAdapter adapter = new DialogueCardAdapter(this, mDialogueCards);
        list_didactisch_bekwaam.setAdapter(adapter);

        list_didactisch_bekwaam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Dida.this, TabActivity.class);
                DialogueCard selectedCard = adapter.getItem(position);
                intent.putExtra("selectedCard", selectedCard);
                Dida.this.startActivity(intent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_right, R.anim.right_left);
    }


}
