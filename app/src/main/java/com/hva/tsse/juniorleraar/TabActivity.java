package com.hva.tsse.juniorleraar;

        import android.os.Bundle;
        import android.support.design.widget.TabLayout;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.Menu;
        import android.view.View;
        import android.widget.TextView;

        import com.hva.tsse.juniorleraar.adapter.SectionsPagerAdapter;
        import com.hva.tsse.juniorleraar.fragment.BekwaamFragment;
        import com.hva.tsse.juniorleraar.fragment.StartbekwaamFragment;
        import com.hva.tsse.juniorleraar.model.DialogueCard;

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

        this.mDialogueCard = (DialogueCard) getIntent().getSerializableExtra("selectedCard");
        this.setTitle("xd");

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
        mSectionsPagerAdapter.addFragment(new BekwaamFragment(),TITLE_FRAGMENT_BEKWAAM );
        mSectionsPagerAdapter.addFragment(new StartbekwaamFragment(), TITLE_FRAGMENT_STARTBEKWAAM);
        viewpager.setAdapter(mSectionsPagerAdapter);
    }

}

