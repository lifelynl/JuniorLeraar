package com.hva.tsse.juniorleraar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hva.tsse.juniorleraar.R;
import com.hva.tsse.juniorleraar.adapter.DialogueCardAdapter;
import com.hva.tsse.juniorleraar.firebase.Firebase;
import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartbekwaamFragment extends Fragment
{
    private static final String TAG = "STARTBEKWAAMFRAGMENT";

    private Firebase mFirebase;
    private List<DialogueCard> mDialogueCards;

    public StartbekwaamFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_startbekwaam, container, false);
        rootView.setTag(TAG);

        DialogueCardAdapter adapter = new DialogueCardAdapter();
        mDialogueCards = adapter.getAllCards();
        Log.w(TAG, "Number of object from Firebase: " + mDialogueCards.size());

        return rootView;
    }
}
