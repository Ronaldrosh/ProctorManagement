package com.example.ronaldfernandes.proctormanagement;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Date;

public class MeetingDate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_date);
        DatePicker mdate;
        mdate = (DatePicker)findViewById(R.id.dateMeeting);
        Text MeetingDate;
        //MeetingDate = (Text) mdate.getMonth();
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
        DatePicker dateFrom = (DatePicker) findViewById(R.id.dateMeeting);
        int fromMonth = dateFrom.getMonth()+1;
        int fromDay = dateFrom.getDayOfMonth();
        int fromYear = dateFrom.getYear();

        String date = String.valueOf(fromDay)+"/"+String.valueOf(fromMonth)+"/"+String.valueOf(fromYear);
        Toast.makeText(this,"Meeting Scheduled on " +date, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MeetingTime.class);
        intent.putExtra("Date",date);
        startActivity(intent);
    }

}
