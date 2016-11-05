package com.prithvi.example;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class sponsors extends Fragment implements View.OnClickListener,
    allsponsors.OnFragmentInteractionListener{

    private OnFragmentInteractionListener mListener;

    ImageButton mugambigai,daikin,johnson,lnt,syndicate,coromandel, buildcraft;


    public static sponsors newInstance() {
        sponsors fragment = new sponsors();
        return fragment;
    }

    public sponsors() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sponsors, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mugambigai=(ImageButton) getActivity().findViewById(R.id.mugambigai);
        mugambigai.setOnClickListener(this);
        daikin=(ImageButton) getActivity().findViewById(R.id.daikin);
        daikin.setOnClickListener(this);
        lnt=(ImageButton) getActivity().findViewById(R.id.lnt);
        lnt.setOnClickListener(this);
        syndicate=(ImageButton) getActivity().findViewById(R.id.syndicate);
        syndicate.setOnClickListener(this);
        johnson=(ImageButton) getActivity().findViewById(R.id.johnson);
        johnson.setOnClickListener(this);
        coromandel=(ImageButton) getActivity().findViewById(R.id.coromandel);
        coromandel.setOnClickListener(this);
        buildcraft=(ImageButton) getActivity().findViewById(R.id.buildcraft);
        buildcraft.setOnClickListener(this);

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager=getFragmentManager();


        if(v==mugambigai)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, allsponsors.newInstance("mugambigai"))
                    .addToBackStack(null).commit();

        }
        else if (v==daikin)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, allsponsors.newInstance("daikin"))
                    .addToBackStack(null).commit();

        }
        else if (v==syndicate)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, allsponsors.newInstance("syndicate"))
                    .addToBackStack(null).commit();


        }
        else if (v==lnt)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, allsponsors.newInstance("lnt"))
                    .addToBackStack(null).commit();

        }
        else if (v==johnson)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, allsponsors.newInstance("johnson"))
                    .addToBackStack(null).commit();

        }
        else if (v==coromandel)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, allsponsors.newInstance("coromandel"))
                    .addToBackStack(null).commit();

        }
        else if (v==buildcraft)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, allsponsors.newInstance("buildcraft"))
                    .addToBackStack(null).commit();

        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
