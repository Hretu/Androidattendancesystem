package com.androidattendancesystem.components;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidattendancesystem.R;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    public static Activity activity;
    ArrayList names;

    public GridAdapter(Activity activity, ArrayList names) {
        this.activity = activity;
        this.names = names;
    }

    public static void makeNotification(String userIntrouble) {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(activity.getBaseContext());
        Uri ring = Uri.parse(sharedPrefs.getString("Notification_Sound", Settings.System.DEFAULT_RINGTONE_URI.toString()));

        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity.getBaseContext())
                .setTicker("Ticker Title").setContentTitle("Notes Are Available For this subject")
                .setSmallIcon(R.drawable.ic_notes)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(userIntrouble))

                .setSound(ring);

        Notification noti = builder.build();
        noti.flags = Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) activity.getSystemService(activity.NOTIFICATION_SERVICE);
        notificationManager.notify(0, noti);
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(activity);
            v = vi.inflate(R.layout.grid_layout, null);
        }
        TextView textView = (TextView) v.findViewById(R.id.namePlacer);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageHolder);
        if (names.get(position).toString().equals("ATTENDANCE")) {
            imageView.setImageResource(R.drawable.ic_attendance);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


        } else if (names.get(position).toString().equals("NOTES")) {
            imageView.setImageResource(R.drawable.ic_notes);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        } else if (names.get(position).toString().equals("PROFILE")) {
            imageView.setImageResource(R.drawable.ic_profile);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


        }
        textView.setText(names.get(position).toString());
        return v;
    }

    }

