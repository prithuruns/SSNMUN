package com.prithvi.example;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class nav_draw extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        addressLetter.OnFragmentInteractionListener,
        IpHeads.OnFragmentInteractionListener,
        Contact_us.OnFragmentInteractionListener,
        Homepage.OnFragmentInteractionListener,
        CouncilHomePage.OnFragmentInteractionListener,
        studyGuidesFragment.OnFragmentInteractionListener,
        preambwordsFragment.OnFragmentInteractionListener,
        opClausesFragment.OnFragmentInteractionListener,
        ROP.OnFragmentInteractionListener,
        delaffairs.OnFragmentInteractionListener,
        finance.OnFragmentInteractionListener,
        sponsorship.OnFragmentInteractionListener,
        hospandlog.OnFragmentInteractionListener,
        techanddes.OnFragmentInteractionListener,
        SecretariatFragment.OnFragmentInteractionListener,
        UNCharterFragment.OnFragmentInteractionListener,
        declhooman.OnFragmentInteractionListener,
        chapters.OnFragmentInteractionListener,
        disec.OnFragmentInteractionListener,
        sc.OnFragmentInteractionListener,
        hrc.OnFragmentInteractionListener,
        ec.OnFragmentInteractionListener,
        iaea.OnFragmentInteractionListener,
        settingsFragment.OnFragmentInteractionListener,
        Ip.OnFragmentInteractionListener,
        sponsors.OnFragmentInteractionListener,
        allsponsors.OnFragmentInteractionListener,
        mapTrans.OnFragmentInteractionListener,
        schedule.OnFragmentInteractionListener,
        busroutes.OnFragmentInteractionListener{

    TextView textView;

    private NavigationDrawerFragment mNavigationDrawerFragment;

    private CharSequence mTitle;
    private boolean doubleBackToExitPressedOnce=false;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_draw);

        //textView=(TextView) findViewById(R.id.blankfrag);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_draw);
        mTitle = getTitle();


        // Set the alarm to start at 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH,9);
        calendar.set(Calendar.DATE,8);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 11);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        alarmMgr = (AlarmManager)getBaseContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(getBaseContext(), 0, intent, 0);

        alarmMgr.set(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(), alarmIntent);
        Log.i("alarm","being set I think");
        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch(position)
        {
            case 0:
                fragmentManager.beginTransaction()
                    .replace(R.id.container, Homepage.newInstance())
                                         .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);
              //  textView.setText("Not so blank now.");
                break;
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, addressLetter.newInstance())
                                             .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);
                //    textView.setText("Pretty blank bro.");
                break;
            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, CouncilHomePage.newInstance())
                                             .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);
                //    textView.setText("Pretty blank bro.");
                break;
            case 3:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, Ip.newInstance())
                                            .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);
                //    textView.setText("Pretty blank bro.");
                break;
            case 4:
            fragmentManager.beginTransaction()
                    .replace(R.id.container, SecretariatFragment.newInstance())
                                         .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);
                 //    textView.setText("Pretty blank bro.");
                break;
            case 5:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, studyGuidesFragment.newInstance())
                                             .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);
                //    textView.setText("Pretty blank bro.");
                break;

            case 6:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, sponsors.newInstance())
                                             .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);
                //    textView.setText("Pretty blank bro.");
                break;
            case 7:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, mapTrans.newInstance())
                                            .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);
                //    textView.setText("Pretty blank bro.");
                break;
            case 8:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, Contact_us.newInstance())
                        .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);
                //    textView.setText("Pretty blank bro.");
                break;

        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(R.string.app_name);
    }

    @Override
    public void onBackPressed() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStackImmediate();
        } else
        {
            this.moveTaskToBack(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.nav_draw, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.container,settingsFragment.newInstance())
                                         .addToBackStack(null).commit();
            getSupportActionBar().setTitle(R.string.app_name);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(String string){

    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_nav_draw, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((nav_draw) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
