package com.hva.tsse.juniorleraar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hva.tsse.juniorleraar.R;


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
        View rootView = inflater.inflate(R.layout.fragment_bekwaam, container, false);
        rootView.setTag(TAG);



        return rootView;
    }
}
