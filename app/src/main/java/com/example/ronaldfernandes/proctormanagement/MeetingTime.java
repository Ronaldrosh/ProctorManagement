package com.example.ronaldfernandes.proctormanagement;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;

public class MeetingTime extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_time);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(Color.WHITE);
            getSupportActionBar().setTitle("Schedule Meeting");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
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

        TimePicker time;
        time = (TimePicker) findViewById(R.id.timeMeeting);
        int min, hr;
        hr=time.getCurrentHour();
        min=time.getCurrentMinute();
        String tym = hr+":"+min;
        Toast.makeText(MeetingTime.this, "Time"+tym, Toast.LENGTH_SHORT).show();
        String date = getIntent().getExtras().getString("Date");
        //Toast.makeText(MeetingTime.this, "date"+date, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ScheduleMeeting.class);

        intent.putExtra("Time",tym);
        intent.putExtra("Date",date);
        startActivity(intent);

    }
}
