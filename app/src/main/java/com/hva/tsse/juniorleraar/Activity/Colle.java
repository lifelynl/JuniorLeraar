package com.hva.tsse.juniorleraar.Activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
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

public class Colle extends AppCompatActivity {

    private ListView list_collegiale_samenwerking;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colle);

        ColorUtils.darkenStatusBar(this, R.color.colorCollegiaal);
        this.setTitle("Collegiale samenwerking");

        list_collegiale_samenwerking = (ListView) findViewById(R.id.list_collegiale_samenwerking);

        List<DialogueCard> mDialogueCards = new ArrayList<>();
        DataSource data = new DataSource();
        mDialogueCards = data.getTitlesCollegialeSamenwerking();

        // set adapter
        final DialogueCardAdapter adapter = new DialogueCardAdapter(this, mDialogueCards);
        list_collegiale_samenwerking.setAdapter(adapter);

        list_collegiale_samenwerking.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Colle.this, TabActivity.class);
                DialogueCard selectedCard = adapter.getItem(position);
                intent.putExtra("selectedCard", selectedCard);
                Colle.this.startActivity(intent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        //title text color
        Spannable text = new SpannableString(this.getTitle());
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        text.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);


        this.setTitle(text);
    }
    //transition overrides
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_right, R.anim.right_left);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.left_right, R.anim.right_left);
            return true;
        }
        return false;
    }
}
