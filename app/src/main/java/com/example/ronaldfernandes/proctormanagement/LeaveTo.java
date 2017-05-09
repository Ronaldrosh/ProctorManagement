package com.example.ronaldfernandes.proctormanagement;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class LeaveTo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_to);
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
    public void Leave(View v){

        DatePicker dateFrom = (DatePicker) findViewById(R.id.dateTo);
        int toMonth = dateFrom.getMonth()+1;
        int toDay = dateFrom.getDayOfMonth();
        int toYear = dateFrom.getYear();
        String to = String.valueOf(toDay)+"/"+String.valueOf(toMonth)+"/"+String.valueOf(toYear);
        Toast.makeText(this,"Until " +to, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ApplyLeave.class);
        String valfrom = getIntent().getExtras().getString("From");
        intent.putExtra("To",to);
        intent.putExtra("From",valfrom);
        startActivity(intent);
    }

}
