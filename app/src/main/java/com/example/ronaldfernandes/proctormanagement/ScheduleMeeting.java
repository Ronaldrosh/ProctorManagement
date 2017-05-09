package com.example.ronaldfernandes.proctormanagement;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Time;

public class ScheduleMeeting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_meeting);
        TextView txtDate = (TextView) findViewById(R.id.textViewDate);
        TextView txtTime = (TextView) findViewById(R.id.textViewTime);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(Color.WHITE);
            getSupportActionBar().setTitle("Schedule Meeting");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        String time = getIntent().getExtras().getString("Time");
        String date= getIntent().getExtras().getString("Date");
        txtTime.setText(""+ time);
        txtDate.setText(""+date);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void SelectDate(View v){
        //Intent intent = new Intent(this,ScheduleMeeting.class);
       // startActivity(intent);
    }
}
