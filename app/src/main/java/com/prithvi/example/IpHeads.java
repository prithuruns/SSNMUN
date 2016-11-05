package com.prithvi.example;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class IpHeads extends Fragment {

    private static final String ARG_IP_HEAD = "ipHead";

    private String mIpHead;

    private OnFragmentInteractionListener mListener;

    TextView designation,content;
    ImageView pic;

    public static IpHeads newInstance(String ipHead) {
        IpHeads fragment = new IpHeads();
        Bundle args = new Bundle();
        args.putString(ARG_IP_HEAD, ipHead);
        fragment.setArguments(args);
        return fragment;
    }

    public IpHeads() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIpHead = getArguments().getString(ARG_IP_HEAD);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ip_heads, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        designation= (TextView) getActivity().findViewById(R.id.designation);
        content=(TextView) getActivity().findViewById(R.id.content);
        pic=(ImageView) getActivity().findViewById(R.id.pic);

        if (mIpHead.equals("noorain"))
        {
            designation.setText("Head of International Press");
            content.setText(R.string.noorian);
            pic.setImageDrawable(getResources().getDrawable(R.mipmap.noorain));
        }
        else if (mIpHead.equals("anantha"))
        {
            designation.setText("Sub-Editor");
            content.setText(R.string.anantha);
            pic.setImageDrawable(getResources().getDrawable(R.mipmap.anantha));
        }
        else if (mIpHead.equals("farhan"))
        {
            designation.setText("Sub-Editor");
            content.setText(R.string.farhan);
            pic.setImageDrawable(getResources().getDrawable(R.mipmap.farhan));
        }

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

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
