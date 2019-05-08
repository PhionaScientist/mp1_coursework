package com.example.phionah.reda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btnlogin, btn_fblogin;
    private static final int RESULT_PROFILE_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents() {
        btn_fblogin = (Button) findViewById(R.id.btn_fblogin);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if (id == R.id.btnlogin) {
                    Intent login = new Intent(MainActivity.this, Login1Activity.class);
                    startActivity(login);
                } else if (id == R.id.btn_fblogin) {
                    Intent facebooklogin = new Intent(MainActivity.this, FacebookLoginActivity.class);
                    startActivity(facebooklogin);
                }
            }
        });
    }
}
