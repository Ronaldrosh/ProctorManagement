package com.example.ronaldfernandes.proctormanagement;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ScholarshipOther extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Spinner spinner;
        setContentView(R.layout.activity_scholarship_other);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(Color.WHITE);
            getSupportActionBar().setTitle("Scholarship And Other");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        spinner = (Spinner) findViewById(R.id.spinner);
        String [] options = {"Scholarship/Award Received","Co-curricular Achievements(State Level and Above)","Extra-curricular Achievements(State Level and Above","Health Record History of Chronic Ailment or Allergy","Any Other Infomation"};
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
}
