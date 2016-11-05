package com.prithvi.example;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class mapTrans extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener,busroutes.OnFragmentInteractionListener{

    private OnFragmentInteractionListener mListener;

    RadioGroup radioGroup;
    int a=0;

    File file;

    Button button;
    Button pdfButton, busroutes;

    public static mapTrans newInstance() {
        mapTrans fragment = new mapTrans();
        return fragment;
    }

    public mapTrans() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_trans, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button=(Button)getActivity().findViewById(R.id.button3);
        button.setOnClickListener(this);

        pdfButton=(Button)getActivity().findViewById(R.id.ssnbr);
        pdfButton.setOnClickListener(this);
        busroutes=(Button)getActivity().findViewById(R.id.busroutes);
        busroutes.setOnClickListener(this);

        radioGroup =(RadioGroup)getActivity().findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(this);

        File fileBrochure = new File("/sdcard/ssnbr.pdf");
        if (!fileBrochure.exists())
        {
            CopyAssetsbrochure();
        }

        /** PDF reader code */
        file = new File("/sdcard/ssnbr.pdf");


    }

    private void CopyAssetsbrochure() {
        AssetManager assetManager = getActivity().getAssets();
        String[] files = null;
        try
        {
            files = assetManager.list("");
        }
        catch (IOException e)
        {
            Log.i("tag", e.getMessage());
        }
        for(int i=0; i<files.length; i++)
        {
            String fStr = files[i];
            if(fStr.equalsIgnoreCase("ssnbr.pdf"))
            {
                InputStream in = null;
                OutputStream out = null;
                try
                {
                    in = assetManager.open(files[i]);
                    out = new FileOutputStream("/sdcard/" + files[i]);
                    copyFile(in, out);
                    in.close();
                    in = null;
                    out.flush();
                    out.close();
                    out = null;
                    break;
                }
                catch(Exception e)
                {
                    Log.e("tag", e.getMessage());
                }
            }
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
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

        if(v==button)
        {
            if(a!=0) {
                Intent i = new Intent("com.prithvi.example.MapsActivity");
                i.putExtra("council", a);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this.getActivity(), "Please choose a council.", Toast.LENGTH_SHORT).show();
            }
        }
        else if(v==pdfButton)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file),"application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try
            {
                startActivity(intent);
            }
            catch (ActivityNotFoundException e)
            {
                Toast.makeText(this.getActivity(), "NO Pdf Viewer", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v==busroutes)
        {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, com.prithvi.example.busroutes.newInstance())
                    .addToBackStack(null).commit();
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId==R.id.rbdisec)
        {
            a=1;
        }
        else if(checkedId==R.id.rbhrc)
        {
            a=2;
        }
        else if(checkedId==R.id.rbec)
        {
            a=3;
        }
        else if(checkedId==R.id.rbsc)
        {
            a=4;
        }
        else if(checkedId==R.id.rbiaea)
        {
            a=5;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
