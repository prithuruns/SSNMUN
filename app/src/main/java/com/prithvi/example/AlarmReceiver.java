package com.prithvi.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by Prithvi on 2015-09-07.
 */
public class AlarmReceiver extends BroadcastReceiver {

    MediaPlayer bgm;

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("alarm","Got called");
        bgm= MediaPlayer.create(context, R.raw.alarm);
        bgm.setLooping(true);

    }
}
