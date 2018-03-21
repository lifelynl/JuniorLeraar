package com.hva.tsse.juniorleraar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.hva.tsse.juniorleraar.adapter.SectionsPagerAdapter;
import com.hva.tsse.juniorleraar.fragment.BekwaamFragment;
import com.hva.tsse.juniorleraar.fragment.StartbekwaamFragment;
import com.hva.tsse.juniorleraar.model.DialogueCard;
import java.lang.reflect.Field;

public class TabActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private static final String TITLE_FRAGMENT_BEKWAAM = "BEKWAAM";
    private static final String TITLE_FRAGMENT_STARTBEKWAAM = "STARTBEKWAAM";
    private DialogueCard mDialogueCard;

    public DialogueCard getmDialogueCard() {
        return mDialogueCard;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setUpViewPager(mViewPager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);

        //set current card and title
        this.mDialogueCard = (DialogueCard) getIntent().getSerializableExtra("selectedCard");
        String mainTitle = this.mDialogueCard.getTitle();
        //set colors for toolbar & tabbar & statusbar
        String theme = this.mDialogueCard.getTheme();
        setBackgroundColorToolbar(theme, toolbar);
        setBackgroundColorTabs(theme, tabLayout);
        setStatusBarColor(theme);
        //Displaying long titles
        try {
            Field f = toolbar.getClass().getDeclaredField("mTitleTextView");
            f.setAccessible(true);
            final TextView toolbarTextView = (TextView) f.get(toolbar);
            toolbarTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            toolbarTextView.setFocusable(true);
            toolbarTextView.setFocusableInTouchMode(true);
            toolbarTextView.requestFocus();
            toolbarTextView.setSingleLine(true);
            toolbarTextView.setSelected(false);
            toolbarTextView.setMarqueeRepeatLimit(1);
            // set text on Textview
            toolbarTextView.setText(mainTitle);
            toolbar.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        if (toolbarTextView.isSelected()) {
                            toolbarTextView.setSelected(false);
                        } else {
                            toolbarTextView.setSelected(true);
                        }
                        return true;
                    } else return false;
                }
            });
        }
        catch (NoSuchFieldException e) {
        }
        catch (IllegalAccessException e) {
        }
    }
    //indent after newline for bullet point list
    static SpannableString createIndentedText(String text, int marginFirstLine, int marginNextLines) {
        SpannableString result=new SpannableString(text);
        result.setSpan(new LeadingMarginSpan.Standard(marginFirstLine, marginNextLines),0,text.length(),0);
        return result;
    }
    //make list with indent
    private static SpannableString makeList(String list){
        String bullet = "\u2022";
        String bulletNewline ="\n\u2022";
        list = list.replace("$", bullet);
        list = list.replace("#", bulletNewline);
        if(list.contains(bullet)){
            SpannableString listFinal = createIndentedText(list, 0,25);
            return listFinal;
        }
        else{
            SpannableString listFinal = createIndentedText(list, 0,10);
            return listFinal;
        }
    }
    public static void displayCard(String result, String indicators, String reflection, View view){
        setResult(view, result);
        setIndicators(view, indicators);
        setReflection(view, reflection);
    }
    public static void setResult(View view, String result){
        SpannableString resultFinal = makeList(result);
        TextView textview = (TextView) view.findViewById(R.id.result);
        textview.setText(resultFinal);
    }
    public static void setIndicators(View view,String indicators){
        SpannableString indicatorsFinal = TabActivity.makeList(indicators);
        TextView textview = (TextView) view.findViewById(R.id.indicators);
        textview.setText(indicatorsFinal);
    }
    public static void setReflection(View view,String reflection){
        SpannableString reflectionFinal = TabActivity.makeList(reflection);
        TextView textview = (TextView) view.findViewById(R.id.reflection);
        textview.setText(reflectionFinal);
    }
    private void setBackgroundColorToolbar(String theme, Toolbar toolbar){
            switch (theme){
                case "Didactisch Bekwaam":
                    toolbar.setBackgroundColor(getResources().getColor((R.color.colorDidactisch)));
                    break;
                case "Collegiale Samenwerking":
                    toolbar.setBackgroundColor(getResources().getColor((R.color.colorCollegiaal)));
                    break;
                case "Pedagogisch Bekwaam":
                    toolbar.setBackgroundColor(getResources().getColor((R.color.colorPedagogisch)));
                    break;
            }
    }
    private void setBackgroundColorTabs(String theme, TabLayout tabLayout){
        switch (theme){
            case "Didactisch Bekwaam":
                tabLayout.setBackgroundColor(getResources().getColor((R.color.colorDidAccent)));
                break;
            case "Collegiale Samenwerking":
                tabLayout.setBackgroundColor(getResources().getColor((R.color.colorCollAccent)));
                break;
            case "Pedagogisch Bekwaam":
                tabLayout.setBackgroundColor(getResources().getColor((R.color.colorPedAccent)));
                break;
        }

    }
    private void setStatusBarColor(String theme) {
        switch (theme) {
            case "Didactisch Bekwaam":
                ColorUtils.darkenStatusBar(this, R.color.colorDidactisch);
                break;
            case "Collegiale Samenwerking":
                ColorUtils.darkenStatusBar(this, R.color.colorCollegiaal);
                break;
            case "Pedagogisch Bekwaam":
                ColorUtils.darkenStatusBar(this, R.color.colorPedagogisch);
                break;
        }
    }
    // Options menu which we don't need unless PO wants HET TRAPPETJE
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_tab, menu);
//
//        return true;
//    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void setUpViewPager(ViewPager viewpager) {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mSectionsPagerAdapter.addFragment(new StartbekwaamFragment(), TITLE_FRAGMENT_STARTBEKWAAM);
        mSectionsPagerAdapter.addFragment(new BekwaamFragment(),TITLE_FRAGMENT_BEKWAAM );
        viewpager.setAdapter(mSectionsPagerAdapter);
    }

}

