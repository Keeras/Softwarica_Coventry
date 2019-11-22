package com.example.softwaricacoventry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPassword;
    private Button btnLogin;
    private ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        MainActivity.this.setTitle("Softwarica APP");

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPswd);
        btnLogin = findViewById(R.id.btnLogin);
        imgLogo = findViewById(R.id.imgLogo);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etName.getText().toString();
                String password = etPassword.getText().toString();


                if (username.isEmpty()) {
                    etName.setError("Please enter Username");
                }else if(password.isEmpty()) {
                    etPassword.setError("Please enter Password");

                } else if (username.equals("softwarica") && password.equals("coventry")){

                        Toast.makeText( MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
//                        Change page
                        Intent keersIntent = new Intent(MainActivity.this, ViewPagerActivity.class);
                        startActivity(keersIntent);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this, "Either username or password donot match",Toast.LENGTH_SHORT).show();
                    }
            }
        });

    }
}
