package com.prithvi.example;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Contact_us extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;

    Button email;

    public static Contact_us newInstance() {
        Contact_us fragment = new Contact_us();
        return fragment;
    }

    public Contact_us() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_us, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        email= (Button) getView().findViewById(R.id.email);
        email.setOnClickListener( this);

    }
    // TODO: Rename method, update argument and hook method into UI event
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
        if(v==email) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //TODO:Change this intent
            intent.setType("plain/text");
            intent.setData(Uri.parse("ssnmuninfo@ssn.edu.in"));
            intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
            //intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"ssnmun.contact@gmail.com"});
            startActivity(intent);
        }
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
