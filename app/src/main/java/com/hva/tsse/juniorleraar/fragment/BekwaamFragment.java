package com.hva.tsse.juniorleraar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hva.tsse.juniorleraar.R;
import com.hva.tsse.juniorleraar.TabActivity;
import com.hva.tsse.juniorleraar.firebase.DataSource;
import com.hva.tsse.juniorleraar.model.DialogueCard;


/**
 * A simple {@link Fragment} subclass.
 */
public class BekwaamFragment extends Fragment
{
    private static final String TAG = "BEKWAAMFRAGMENT";

    public BekwaamFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_card, container, false);
        rootView.setTag(TAG);
        selectCard(rootView);
        return rootView;
    }
    public void selectCard(View view){
        DialogueCard currentCard = ((TabActivity)getActivity()).getmDialogueCard();
        String title = currentCard.getTitle();
        DataSource source = new DataSource();
        DialogueCard currentCardFull = source.getCardFromTitleBekwaam(title);
        String currentResult = currentCard.getResultText();
        String currentTeacher = currentCard.getTeachterText();
        String currentQuestion = currentCard.getQuestionText();
        System.out.println("vanuit bekwaamfragment"+currentCardFull);
        this.displayCard(currentTeacher, currentResult, currentQuestion, view);
    }
    public void displayCard(String result, String indicators, String reflection, View view){
        setResult(view, result);
        setIndicators(view, indicators);
        setReflection(view, reflection);
        view.invalidate();
    }

    public void setResult(View view, String result){
        TextView textview = (TextView) view.findViewById(R.id.result);
        textview.setText(result);
    }
    public void setIndicators(View view,String indicators){
        TextView textview = (TextView) view.findViewById(R.id.indicators);
        textview.setText(indicators);
    }
    public void setReflection(View view,String reflection){
        TextView textview = (TextView) view.findViewById(R.id.reflection);
        textview.setText(reflection);
    }
}
