package com.prithvi.example;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.prithvi.example.dummy.DummyContent;

public class studyGuidesFragment
        extends Fragment
        implements ListView.OnItemClickListener,
        preambwordsFragment.OnFragmentInteractionListener,
        opClausesFragment.OnFragmentInteractionListener,
        ROP.OnFragmentInteractionListener,
        UNCharterFragment.OnFragmentInteractionListener,
        declhooman.OnFragmentInteractionListener{

    private OnFragmentInteractionListener mListener;

    /**
     * The fragment's ListView/GridView.
     */
    private GridView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ListAdapter mAdapter;
    private String[] studyGuide;


    public static studyGuidesFragment newInstance() {
        studyGuidesFragment fragment = new studyGuidesFragment();
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public studyGuidesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        studyGuide=getResources().getStringArray(R.array.studyguides);
        mAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, studyGuide);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_studyguides, container, false);

        // Set the adapter
        mListView = (GridView) view.findViewById(android.R.id.list);
        (mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            //mListener.onFragmentInteraction(DummyContent.ITEMS.get(position).id)
            //
            FragmentManager fragmentManager = getFragmentManager();
            switch(position) {
                case 0:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, ROP.newInstance())
                                                 .addToBackStack(null).commit();

                    break;
                case 1:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, preambwordsFragment.newInstance())
                                                 .addToBackStack(null).commit();
                    //    textView.setText("Pretty blank bro.");
                    break;
                case 2:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, opClausesFragment.newInstance())
                                                 .addToBackStack(null).commit();
                    //    textView.setText("Pretty blank bro.");
                    break;
                case 3:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, UNCharterFragment.newInstance())
                                                 .addToBackStack(null).commit();
                    //    textView.setText("Pretty blank bro.");
                    break;
                case 4:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, declhooman.newInstance())
                                                 .addToBackStack(null).commit();
                    //    textView.setText("Pretty blank bro.");
                    break;

            }
        }
    }

    @Override
    public void onFragmentInteraction(String id) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String id);
    }

}
