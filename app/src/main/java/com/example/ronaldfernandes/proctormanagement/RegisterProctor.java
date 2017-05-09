package com.example.ronaldfernandes.proctormanagement;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class RegisterProctor extends AppCompatActivity implements View.OnClickListener{
    EditText Name, Password, Email, Esn, Phone;
    String fname, password, email,ESN,phone;
    Button buttonRegister;
    private static final String REGISTER_URL = "http://192.168.42.131/Android/regP.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_proctor);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        Name = (EditText) findViewById(R.id.register_name);
        Password = (EditText) findViewById(R.id.register_password);
        Email = (EditText) findViewById(R.id.register_email);
        Esn = (EditText) findViewById(R.id.esn);
        Phone = (EditText)findViewById(R.id.phone);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(Color.WHITE);
            getSupportActionBar().setTitle("Proctor Registration");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        buttonRegister.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == buttonRegister){
                registerProc();
        }
    }

    private void registerProc() {
        fname = Name.getText().toString().trim().toLowerCase();
        password = Password.getText().toString().trim().toLowerCase();
        email = Email.getText().toString().trim().toLowerCase();
        ESN = Esn.getText().toString().trim().toLowerCase();
        phone = Phone.getText().toString().trim().toLowerCase();

        register(fname,password,email,ESN,phone);
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
    private void register(String fname, String password, String email, String ESN,String phone) {
        class RegisterUser extends AsyncTask<String, Void, String>{
            ProgressDialog loading;
            registerP ruc = new registerP();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterProctor.this, "Please Wait",null, true, true);
                //Toast.makeText(RegisterProctor.this, "OnPreExe", Toast.LENGTH_LONG).show();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                //Toast.makeText(RegisterProctor.this, "Post", Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("fname",params[0]);
                data.put("password",params[1]);
                data.put("email",params[2]);
                data.put("ESN",params[3]);
                data.put("phone",params[4]);


                String result = ruc.sendPostRequest(REGISTER_URL,data);

                return  result;
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(fname,password,email,ESN,phone);
    }
}