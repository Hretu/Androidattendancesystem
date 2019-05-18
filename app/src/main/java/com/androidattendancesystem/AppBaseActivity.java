package com.androidattendancesystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

import com.androidattendancesystem.components.GridAdapter;
import com.androidattendancesystem.database.DatabaseHandler;

import java.util.ArrayList;

public class AppBaseActivity extends AppCompatActivity { public static ArrayList<String> divisions;
    public static DatabaseHandler handler;
    public static Activity activity;
    ArrayList<String> basicFields;
    GridAdapter adapter;
    GridView gridView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mai_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_base);
        basicFields = new ArrayList<>();
        handler = new DatabaseHandler(this);
        activity = this;

        getSupportActionBar().show();
        divisions = new ArrayList<>();
        divisions.add("S1 COMPUTER SYSTEM");
        divisions.add("S2 ANDROID APPLICATION DEVELOPMENT");
        divisions.add("S3 WEB API DEVELOPMENT");
        divisions.add("S4 PERVASIVE COMPUTING");
        divisions.add("S5 AGILE DEVELOPMENT");
        divisions.add("S6 COMPUTING PROJECT");
        divisions.add("S7 ANALYSIS DESIGN AND IMPLEMENTATION");
        gridView = (GridView) findViewById(R.id.grid);
        basicFields.add("ATTENDANCE");
        basicFields.add("SCHEDULER");
        basicFields.add("NOTES");
        basicFields.add("PROFILE");

        adapter = new GridAdapter(this, basicFields);
        gridView.setAdapter(adapter);
    }

    public void loadSettings(MenuItem item) {

    }

    public void loadAbout(MenuItem item) {

    }}
