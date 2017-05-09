package com.example.ronaldfernandes.proctormanagement;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;
import static com.example.ronaldfernandes.proctormanagement.R.styleable.Toolbar;

/**
 * A login screen that offers login via email/password.
 */
public class Proctor extends AppCompatActivity {


    private TextView mEmailView;
    private EditText mPasswordView;
    private FirebaseAuth mAuth;
    private Button mLogin;
    private FirebaseAuth.AuthStateListener mAuthListener;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proctor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(Color.WHITE);
            getSupportActionBar().setTitle("Proctor Login");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);



            mPasswordView = (EditText) findViewById(R.id.password);
            mEmailView = (EditText) findViewById(R.id.email);
            mLogin = (Button) findViewById(R.id.login);
            mAuth = FirebaseAuth.getInstance();
            mAuthListener = new FirebaseAuth.AuthStateListener(){
              @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                  if(firebaseAuth.getCurrentUser()!= null){
                      startActivity(new Intent(Proctor.this, proctorHome.class));
                  }
              }
            };
            mLogin.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    startSignIn();
                }
            });

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

    @Override
    protected void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void Register(View e)
    {
        Intent g = new Intent(this, RegisterProctor.class);
        startActivity(g);
    }
    private  void startSignIn(){
        String email = mEmailView.getText().toString();
        String pass = mPasswordView.getText().toString();
        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Fill in the Empty fields", Toast.LENGTH_SHORT).show();
        }
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(!task.isSuccessful()){
                    Toast.makeText(Proctor.this, "Couldn't Sign In", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}

