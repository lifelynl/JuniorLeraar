package com.hva.tsse.juniorleraar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hva.tsse.juniorleraar.R;
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
        View rootView = inflater.inflate(R.layout.fragment_startbekwaam, container, false);
        rootView.setTag(TAG);

        mRecyclerview = (RecyclerView) rootView.findViewById(R.id.startbekwaamlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerview.setLayoutManager(mLayoutManager);
        mRecyclerview.setHasFixedSize(true);

        //Adding ItemAnimator
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(100L);
        itemAnimator.setRemoveDuration(100L);
        mRecyclerview.setItemAnimator(itemAnimator);

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
        return rootView;
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
