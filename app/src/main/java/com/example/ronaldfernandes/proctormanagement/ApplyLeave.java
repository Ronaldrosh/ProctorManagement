package com.example.ronaldfernandes.proctormanagement;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ApplyLeave extends AppCompatActivity {


    private TextView LeaveFrom;
    private TextView LeaveTo;

   private DatePickerDialog myDateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_leave);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(Color.WHITE);
            getSupportActionBar().setTitle("Leave Application");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        LeaveTo = (TextView) findViewById(R.id.textViewTime);
        LeaveFrom = (TextView) findViewById(R.id.textViewDate);
        String F = getIntent().getExtras().getString("From");
        String T = getIntent().getExtras().getString("To");
        LeaveTo.setText("Leave Until: "+T);
        LeaveFrom.setText("Leave From: "+F);

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
 public void onClick(View v){

 }

}
