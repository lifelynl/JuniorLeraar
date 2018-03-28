package com.hva.tsse.juniorleraar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hva.tsse.juniorleraar.R;
import com.hva.tsse.juniorleraar.TabActivity;
import com.hva.tsse.juniorleraar.data.DataSource;
import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartbekwaamFragment extends Fragment
{
    private static final String TAG = "STARTBEKWAAMFRAGMENT";

    private List<DialogueCard> mDialogueCards;
    private RecyclerView mRecyclerview;

    public StartbekwaamFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View SBrootView = inflater.inflate(R.layout.fragment_card_sb, container, false);
        SBrootView.setTag(TAG);

//        mRecyclerview = (RecyclerView) rootView.findViewById(R.id.startbekwaamlist);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        mRecyclerview.setLayoutManager(mLayoutManager);
//        mRecyclerview.setHasFixedSize(true);
//
//        //Adding ItemAnimator
//        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
//        itemAnimator.setAddDuration(100L);
//        itemAnimator.setRemoveDuration(100L);
//        mRecyclerview.setItemAnimator(itemAnimator);

        //Adding Gestures, this makes you possible to swipe and move cards inside the ListView
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP
                | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT)
        {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerview);
        selectCard(SBrootView);
        return SBrootView;
    }
    public void selectCard(View view){
        DialogueCard currentCard = ((TabActivity)getActivity()).getmDialogueCard();
        String title = currentCard.getTitle();
        System.out.println(title);
        DataSource source = new DataSource();
        DialogueCard currentCardFull = source.getCardFromTitleStartbekwaam(title);
        String currentResult = currentCard.getResultText();
        String currentTeacher = currentCard.getTeacherText();
        String currentQuestion = currentCard.getQuestionText();
        System.out.println("vanuit SBFragment"+currentCardFull);
        this.displayCard(currentTeacher, currentResult, currentQuestion, view);
    }
    public void displayCard(String result, String indicators, String reflection, View view){
        setResult(view, result);
        setIndicators(view, indicators);
        setReflection(view, reflection);
    }

    public void setResult(View view, String result){
        TextView textview = (TextView) view.findViewById(R.id.result_sb);
        textview.setText(result);
    }
    public void setIndicators(View view,String indicators){
        TextView textview = (TextView) view.findViewById(R.id.indicators_sb);
        textview.setText(indicators);
    }
    public void setReflection(View view,String reflection){
        TextView textview = (TextView) view.findViewById(R.id.reflection_sb);
        textview.setText(reflection);
    }

    public void onResume() {
        super.onResume();  // Always call the superclass method first
        updateUI();
    }

    public void updateUI() {

//        if (mAdapter == null) {
//            mAdapter = new DialogueCardAdapter();
//            mRecyclerview.setAdapter(mAdapter);
//        } else {
//            mAdapter.updateList(mDialogueCards);
//            mAdapter.notifyDataSetChanged();
//        }
    }
}
