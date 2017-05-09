package com.example.ronaldfernandes.proctormanagement;

import android.content.Intent;
import android.graphics.Color;
import android.icu.text.DateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class LeaveFrom extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_leave_from);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(Color.WHITE);
            getSupportActionBar().setTitle("Leave Application");
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
    public void Next(View v){
        DatePicker dateFrom = (DatePicker) findViewById(R.id.dateFrom);
        int fromMonth = dateFrom.getMonth()+1;
        int fromDay = dateFrom.getDayOfMonth();
        int fromYear = dateFrom.getYear();

        String from = String.valueOf(fromDay)+"/"+String.valueOf(fromMonth)+"/"+String.valueOf(fromYear);
        Toast.makeText(this,"From " +from, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,LeaveTo.class);
        intent.putExtra("From",from);
        startActivity(intent);
    }
}
