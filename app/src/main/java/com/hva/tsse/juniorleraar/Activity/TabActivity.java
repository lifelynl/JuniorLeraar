package com.hva.tsse.juniorleraar.Activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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

import com.hva.tsse.juniorleraar.ColorUtils;
import com.hva.tsse.juniorleraar.R;
import com.hva.tsse.juniorleraar.adapter.SectionsPagerAdapter;
import com.hva.tsse.juniorleraar.fragment.BekwaamFragment;
import com.hva.tsse.juniorleraar.fragment.StartbekwaamFragment;
import com.hva.tsse.juniorleraar.model.DialogueCard;
import java.lang.reflect.Field;

public class TabActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private DialogueCard mDialogueCard;
    public DialogueCard getmDialogueCard() {
        return mDialogueCard;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        setUpViewPager(mViewPager);
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);
        //set current card and title
        this.mDialogueCard = (DialogueCard) getIntent().getSerializableExtra("selectedCard");
        String mainTitle = this.mDialogueCard.getTitle();
        //set colors for toolbar & tabbar & statusbar
        String theme = this.mDialogueCard.getTheme();
        setBackgroundColors(theme, toolbar, tabLayout);
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
            System.out.println("Title Field not found");
        }
        catch (IllegalAccessException e) {
            System.out.println("Title Field not accessible");
        }
    }
    //indent after newline for bullet point list
    static SpannableString createIndentedText(String text, int marginFirstLine, int marginNextLines) {
        SpannableString result=new SpannableString(text);
        result.setSpan(new LeadingMarginSpan.Standard(marginFirstLine, marginNextLines),0,text.length(),0);
        return result;
    }
    //make bulleted list with an indent for every line after a newline (\n)
    private static SpannableString makeList(String list){
        String bullet = "\u2022 ";
        String bulletNewline ="\n\u2022 ";
        int marginNextLine = 20;
        int marginFirstLine = 0;
        list = list.replace("$ ", bullet);
        list = list.replace("# ", bulletNewline);
        list = list.replace(" #", bulletNewline);
        list = list.replace("#", bulletNewline);
        SpannableString listFinal = createIndentedText(list, marginFirstLine,marginNextLine);
        return listFinal;

    }
    public static void displayCard(String result, String indicators, String reflection, View view){
        setResult(view, result);
        setIndicators(view, indicators);
        setReflection(view, reflection);
    }
    public static void setResult(View view, String result){
        TextView textview = view.findViewById(R.id.result);
        textview.setText(result);
    }
    public static void setIndicators(View view,String indicators){
        SpannableString indicatorsFinal = TabActivity.makeList(indicators);
        TextView textview = view.findViewById(R.id.indicators);
        textview.setText(indicatorsFinal);
    }
    public static void setReflection(View view,String reflection){
        SpannableString reflectionFinal = TabActivity.makeList(reflection);
        TextView textview = view.findViewById(R.id.reflection);
        textview.setText(reflectionFinal);
    }
    private void setBackgroundColors(String theme, Toolbar toolbar, TabLayout tablayout){
        switch (theme){
            case "Didactisch Bekwaam":
                toolbar.setBackgroundColor(getResources().getColor((R.color.colorDidactisch)));
                tabLayout.setBackgroundColor(getResources().getColor((R.color.colorDidactisch)));
                break;
            case "Collegiale Samenwerking":
                toolbar.setBackgroundColor(getResources().getColor((R.color.colorCollegiaal)));
                tablayout.setBackgroundColor(getResources().getColor((R.color.colorCollegiaal)));
                break;
            case "Pedagogisch Bekwaam":
                toolbar.setBackgroundColor(getResources().getColor((R.color.colorPedagogisch)));
                tablayout.setBackgroundColor(getResources().getColor((R.color.colorPedagogisch)));
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
    @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_right, R.anim.right_left);
        }

    public void setUpViewPager(ViewPager viewpager) {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mSectionsPagerAdapter.addFragment(new StartbekwaamFragment(), getString(R.string.startbekwaam));
        mSectionsPagerAdapter.addFragment(new BekwaamFragment(),getString(R.string.bekwaam) );
        viewpager.setAdapter(mSectionsPagerAdapter);
    }
}

