package com.prithvi.example;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Ip extends Fragment implements View.OnClickListener,
        IpHeads.OnFragmentInteractionListener{

    private OnFragmentInteractionListener mListener;
    Button bnoorian,banantha,bfarhan;

    public static Ip newInstance() {
        Ip fragment = new Ip();
        return fragment;
    }

    public Ip() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ip, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bnoorian=(Button) getActivity().findViewById(R.id.bnoorian);
        bnoorian.setOnClickListener(this);
        banantha=(Button) getActivity().findViewById(R.id.banantha);
        banantha.setOnClickListener(this);
        bfarhan=(Button) getActivity().findViewById(R.id.bfarhan);
        bfarhan.setOnClickListener(this);

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

        FragmentManager fragmentManager = getFragmentManager();
        if(v==bnoorian)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.container,IpHeads.newInstance("noorain"))
                    .addToBackStack(null)
                    .commit();

        }
        else if (v==banantha)
        {

            fragmentManager.beginTransaction()
                    .replace(R.id.container,IpHeads.newInstance("anantha"))
                    .addToBackStack(null)
                    .commit();

        }

        else if (v==bfarhan)
        {

            fragmentManager.beginTransaction()
                    .replace(R.id.container,IpHeads.newInstance("farhan"))
                    .addToBackStack(null)
                    .commit();

        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
