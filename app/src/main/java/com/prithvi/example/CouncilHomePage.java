package com.prithvi.example;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class CouncilHomePage
        extends Fragment
        implements View.OnClickListener,
        disec.OnFragmentInteractionListener,
        sc.OnFragmentInteractionListener,
        hrc.OnFragmentInteractionListener,
        ec.OnFragmentInteractionListener,
        iaea.OnFragmentInteractionListener {

    private OnFragmentInteractionListener mListener;

    ImageButton disec;
    ImageButton ec;
    ImageButton hrc;
    ImageButton iaea;
    ImageButton sc;
    Button disecbutton;
    Button ecbutton;
    Button scbutton;
    Button iaeabutton;
    Button hrcbutton;
    private Intent intent;
    private NavigationDrawerFragment navigationDrawer=new NavigationDrawerFragment();

    public static CouncilHomePage newInstance() {
        CouncilHomePage fragment = new CouncilHomePage();
        return fragment;
    }

    public CouncilHomePage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_council_home_page, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        disec=(ImageButton) getView().findViewById(R.id.disec);
        ec=(ImageButton) getView().findViewById(R.id.ec);
        hrc=(ImageButton) getView().findViewById(R.id.hrc);
        iaea=(ImageButton) getView().findViewById(R.id.iaea);
        sc=(ImageButton) getView().findViewById(R.id.sc);

        disecbutton= (Button) getView().findViewById(R.id.disecbutton);
        scbutton= (Button) getView().findViewById(R.id.scbutton);
        ecbutton= (Button) getView().findViewById(R.id.ecbutton);
        iaeabutton= (Button) getView().findViewById(R.id.iaeabutton);
        hrcbutton= (Button) getView().findViewById(R.id.hrcbutton);

        disecbutton.setOnClickListener(this);
        scbutton.setOnClickListener(this);
        ecbutton.setOnClickListener(this);
        iaeabutton.setOnClickListener(this);
        hrcbutton.setOnClickListener(this);

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
    public void onFragmentInteraction(Uri uri) {

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


    @Override
    public void onClick(View v) {

        FragmentManager fragman=getFragmentManager();
        if (v.equals(disecbutton)) {
            fragman.beginTransaction()
                    .replace(R.id.container, com.prithvi.example.disec.newInstance())
                    .addToBackStack(null)
                    .commit();

        } else if (v.equals(ecbutton)) {
            fragman.beginTransaction()
                    .replace(R.id.container, com.prithvi.example.ec.newInstance())
                                         .addToBackStack(null).commit();

        } else if (v.equals(scbutton)) {
            fragman.beginTransaction()
                    .replace(R.id.container, com.prithvi.example.sc.newInstance())
                                         .addToBackStack(null).commit();

        } else if (v.equals(hrcbutton)) {
            fragman.beginTransaction()
                    .replace(R.id.container, com.prithvi.example.hrc.newInstance())
                                         .addToBackStack(null).commit();

        } else if (v.equals(iaeabutton)) {
            fragman.beginTransaction()
                    .replace(R.id.container, com.prithvi.example.iaea.newInstance())
                                         .addToBackStack(null).commit();

        }

    }

}
