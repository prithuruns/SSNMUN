package com.prithvi.example;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class chapters extends Fragment {

    private static final String CHAPTER_TEXT = "chapterText";

    private String mChapterText;

    private TextView chapterText;

    private OnFragmentInteractionListener mListener;

    public static chapters newInstance(String chapterText) {
        chapters fragment = new chapters();
        Bundle args = new Bundle();
        args.putString(CHAPTER_TEXT, chapterText);
        fragment.setArguments(args);
        return fragment;
    }

    public chapters() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mChapterText = getArguments().getString(CHAPTER_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chapters, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        chapterText=(TextView) getActivity().findViewById(R.id.chapterView);

        if (mChapterText.equals("unCharterIntro"))
        {
            chapterText.setText(R.string.uncharterintro);
        }
        else if (mChapterText.equals("unCharterPreamble"))
        {
            chapterText.setText(R.string.uncharterpreamble);
        }
        else if (mChapterText.equals("chap1"))
        {
            chapterText.setText(R.string.chap1);
        }
        else if (mChapterText.equals("chap2"))
        {
            chapterText.setText(R.string.chap2);
        }
        else if (mChapterText.equals("chap3"))
        {
            chapterText.setText(R.string.chap3);
        }
        else if (mChapterText.equals("chap4"))
        {
            chapterText.setText(R.string.chap4);
        }
        else if (mChapterText.equals("chap5"))
        {
            chapterText.setText(R.string.chap5);
        }
        else if (mChapterText.equals("chap6"))
        {
            chapterText.setText(R.string.chap6);
        }
        else if (mChapterText.equals("chap7"))
        {
            chapterText.setText(R.string.chap7);
        }
        else if (mChapterText.equals("chap8"))
        {
            chapterText.setText(R.string.chap8);
        }
        else if (mChapterText.equals("chap9"))
        {
            chapterText.setText(R.string.chap9);
        }
        else if (mChapterText.equals("chap10"))
        {
            chapterText.setText(R.string.chap10);
        }
        else if (mChapterText.equals("chap11"))
        {
            chapterText.setText(R.string.chap11);
        }
        else if (mChapterText.equals("chap12"))
        {
            chapterText.setText(R.string.chap12);
        }
        else if (mChapterText.equals("chap13"))
        {
            chapterText.setText(R.string.chap13);
        }
        else if (mChapterText.equals("chap14"))
        {
            chapterText.setText(R.string.chap14);
        }
        else if (mChapterText.equals("chap15"))
        {
            chapterText.setText(R.string.chap15);
        }
        else if (mChapterText.equals("chap16"))
        {
            chapterText.setText(R.string.chap16);
        }
        else if (mChapterText.equals("chap17"))
        {
            chapterText.setText(R.string.chap17);
        }
        else if (mChapterText.equals("chap18"))
        {
            chapterText.setText(R.string.chap18);
        }
        else if (mChapterText.equals("chap19"))
        {
            chapterText.setText(R.string.chap19);
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
