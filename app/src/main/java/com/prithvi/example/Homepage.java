package com.prithvi.example;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Homepage extends Fragment implements View.OnClickListener,schedule.OnFragmentInteractionListener {

    private OnFragmentInteractionListener mListener;

    int a=0,b=0;

    Timer timer;
    TimerTask timerTask;

    ImageView UNIC;
    ImageView ROMUN;
    Button schedule;

    public static Homepage newInstance() {
        Homepage fragment = new Homepage();
        return fragment;
    }

    public Homepage() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Typeface font = Typeface.createFromAsset(getResources().getAssets(), "ArchitectsDaughter.ttf");
        TextView tv = (TextView) getActivity().findViewById(R.id.textView66);
        tv.setTypeface(font);
        tv.setTextColor(getResources().getColor(R.color.councilhomepageicon));
        TextView time = (TextView) getActivity().findViewById(R.id.countdowntimer);
        time.setTypeface(font);

        schedule=(Button) getActivity().findViewById(R.id.schedule);
        schedule.setOnClickListener(this);

        UNIC= (ImageView) getActivity().findViewById(R.id.imageView40);
        ROMUN= (ImageView) getActivity().findViewById(R.id.imageView41);
    }


    private void runThread() {
        new Thread() {
            public void run() {

                getActivity().runOnUiThread(
                        new Runnable() {
                                                @Override
                                                public void run() {
                                                    TextView time = (TextView) getActivity().findViewById(R.id.countdowntimer);
                                                    Calendar cd = Calendar.getInstance();
                                                    int date = cd.get(Calendar.DATE);
                                                    int hour = cd.get(Calendar.HOUR_OF_DAY);
                                                    int minute = cd.get(Calendar.MINUTE);
                                                    int second = cd.get(Calendar.SECOND);
                                                    int temp;

                                                    date = 18 - date;
                                                    if (hour > 9) {
                                                        date--;
                                                        hour = 24+9-hour;
                                                    }
                                                    else
                                                    {
                                                        hour=9-hour;
                                                    }
                                                    if (minute>0) {
                                                        hour--;
                                                        minute = 60 - minute;
                                                    }

                                                    if (second>0) {
                                                        minute--;
                                                        second = 60 - second;
                                                    }

                                                    if (second % 2 != 0) {
                                                        time.setTextColor(getResources().getColor(R.color.darkertext));
                                                        time.setBackgroundColor(getResources().getColor(R.color.councilhomepageicontouched));
                                                    } else {
                                                        time.setBackgroundColor(getResources().getColor(R.color.seethrough));
                                                        time.setTextColor(getResources().getColor(R.color.councilhomepageicon));
                                                    }


                                                    time.setText( + date + ":" + hour + ":" + minute + ":" + second + " left till the SSNMUN!!");
                                                }

                                            }
                );
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public void onPause() {
        super.onStop();

        timer.cancel();
    }

    @Override
    public void onResume() {
        super.onResume();

        timer=new Timer();
        timerTask=new TimerTask() {
            @Override
            public void run() {

                runThread();
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_1, container, false);
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
        if(v==UNIC)
        {
            Uri webpage=Uri.parse("http://www.unic.org.in");
            Intent intent=new Intent(Intent.ACTION_VIEW,webpage);
            startActivity(intent);

        }
        else if(v==ROMUN)
        {
                Uri webpage=Uri.parse("http://www.romun.org");
                Intent intent=new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(intent);
        }
        else if(v==schedule)
        {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, com.prithvi.example.schedule.newInstance())
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
