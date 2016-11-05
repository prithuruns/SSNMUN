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

public class SecretariatFragment
        extends Fragment
        implements ListView.OnItemClickListener,
        delaffairs.OnFragmentInteractionListener,
        finance.OnFragmentInteractionListener,
        sponsorship.OnFragmentInteractionListener,
        hospandlog.OnFragmentInteractionListener,
        techanddes.OnFragmentInteractionListener{


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
    private String[] secretariat;

    public static SecretariatFragment newInstance() {
        SecretariatFragment fragment = new SecretariatFragment();
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SecretariatFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        secretariat=getResources().getStringArray(R.array.secretariat);

        mAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, secretariat);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_secretariat, container, false);

        // Set the adapter
        mListView = (GridView) view.findViewById(android.R.id.list);
        ( mListView).setAdapter(mAdapter);

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
            FragmentManager fragman=getFragmentManager();
            switch(position){
                case 0:
                    fragman.beginTransaction()
                            .replace(R.id.container,delaffairs.newInstance())
                                                 .addToBackStack(null).commit();
                    break;
                case 1:
                    fragman.beginTransaction()
                            .replace(R.id.container,finance.newInstance())
                                                 .addToBackStack(null).commit();
                    break;
                case 2:
                    fragman.beginTransaction()
                            .replace(R.id.container,sponsorship.newInstance())
                                                 .addToBackStack(null).commit();
                    break;
                case 3:
                    fragman.beginTransaction()
                            .replace(R.id.container,hospandlog.newInstance())
                                                 .addToBackStack(null).commit();
                    break;
                case 4:
                    fragman.beginTransaction()
                            .replace(R.id.container,techanddes.newInstance())
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
