package com.prithvi.example;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class allsponsors extends Fragment {
    private static final String SPONSOR_NAME = "sponsorName";

    private String mSponsorName;

    private OnFragmentInteractionListener mListener;
    
    TextView title;
    TextView text;


    public static allsponsors newInstance(String sponsorName) {
        allsponsors fragment = new allsponsors();
        Bundle args = new Bundle();
        args.putString(SPONSOR_NAME, sponsorName);
        fragment.setArguments(args);
        return fragment;
    }

    public allsponsors() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSponsorName = getArguments().getString(SPONSOR_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.all_sponsors, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        title=(TextView) getActivity().findViewById(R.id.title);
        text=(TextView) getActivity().findViewById(R.id.text);
        
        if (mSponsorName.equals("mugambigai"))
        {
            title.setText(R.string.title_mugambigai);
            text.setText(R.string.mugambigai);
        }
        else if (mSponsorName.equals("daikin"))
        {
            title.setText(R.string.title_daikin);
            text.setText(R.string.daikin);
        }
        else if (mSponsorName.equals("syndicate"))
        {
            title.setText(R.string.title_syndicate);
            text.setText(R.string.syndicate);
        }
        else if (mSponsorName.equals("lnt"))
        {
            title.setText(R.string.title_lnt);
            text.setText(R.string.lnt);
        }
        else if (mSponsorName.equals("johnson"))
        {
            title.setText(R.string.title_johnson);
            text.setText(R.string.johnson);
            text.setGravity(Gravity.NO_GRAVITY);
        }
        else if (mSponsorName.equals("coromandel"))
        {
            title.setText(R.string.title_coromandel);
            text.setText(R.string.coromandel);
        }
        else if (mSponsorName.equals("buildcraft"))
        {
            title.setText(R.string.title_buildcraft);
            text.setText(R.string.buildcraft);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
