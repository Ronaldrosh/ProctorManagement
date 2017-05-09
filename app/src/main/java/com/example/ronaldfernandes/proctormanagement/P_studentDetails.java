package com.example.ronaldfernandes.proctormanagement;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static com.example.ronaldfernandes.proctormanagement.R.id.spinner;
import static com.example.ronaldfernandes.proctormanagement.R.id.toolbar;

public class P_studentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_student_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(Color.WHITE);
            getSupportActionBar().setTitle("Search Student");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Spinner spinner;
        spinner = (Spinner) findViewById(R.id.Spinner);
        String [] options = {"USN","Name"};

        ArrayAdapter Adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,options);
        spinner.setAdapter(Adapter);
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