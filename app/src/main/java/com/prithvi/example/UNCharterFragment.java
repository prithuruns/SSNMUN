package com.prithvi.example;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.prithvi.example.dummy.DummyContent;

public class UNCharterFragment
        extends Fragment
        implements ListView.OnItemClickListener,
        chapters.OnFragmentInteractionListener
{
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

    private String[] uncharter;

    public static UNCharterFragment newInstance() {
        UNCharterFragment fragment = new UNCharterFragment();
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UNCharterFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        uncharter=getResources().getStringArray(R.array.UNcharter);

        mAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, uncharter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uncharter, container, false);

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
                            .replace(R.id.container, chapters.newInstance("unCharterIntro"))
                                                 .addToBackStack(null).commit();
                    break;
                case 1:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("unCharterPreamble"))
                                                 .addToBackStack(null).commit();
                    break;
                case 2:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap1"))
                                                 .addToBackStack(null).commit();
                    break;
                case 3:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap2"))
                                                 .addToBackStack(null).commit();
                    break;
                case 4:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap3"))
                                                 .addToBackStack(null).commit();
                    break;
                case 5:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap4"))
                                                 .addToBackStack(null).commit();
                    break;
                case 6:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap5"))
                                                 .addToBackStack(null).commit();
                    break;
                case 7:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap6"))
                                                 .addToBackStack(null).commit();
                    break;
                case 8:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap7"))
                                                 .addToBackStack(null).commit();
                    break;
                case 9:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap8"))
                                                 .addToBackStack(null).commit();
                    break;
                case 10:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap9"))
                                                 .addToBackStack(null).commit();
                    break;
                case 11:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap10"))
                                                 .addToBackStack(null).commit();
                    break;
                case 12:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap11"))
                                                 .addToBackStack(null).commit();
                    break;
                case 13:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap12"))
                                                 .addToBackStack(null).commit();
                    break;
                case 14:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap13"))
                                                 .addToBackStack(null).commit();
                    break;
                case 15:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap14"))
                                                 .addToBackStack(null).commit();
                    break;
                case 16:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap15"))
                                                 .addToBackStack(null).commit();
                    break;
                case 17:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap16"))
                                                 .addToBackStack(null).commit();
                    break;
                case 18:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap17"))
                                                 .addToBackStack(null).commit();
                    break;
                case 19:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap18"))
                                                 .addToBackStack(null).commit();
                    break;
                case 20:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, chapters.newInstance("chap19"))
                                                 .addToBackStack(null).commit();
                    break;

            }
        }
    }


    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(String id);
    }

}
