package com.hva.tsse.juniorleraar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hva.tsse.juniorleraar.R;


public class SearchFragment extends Fragment {
    private static final String TAG = "SEARCHFRAGMENT";

    public SearchFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        rootView.setTag(TAG);




        return rootView;
    }
}
