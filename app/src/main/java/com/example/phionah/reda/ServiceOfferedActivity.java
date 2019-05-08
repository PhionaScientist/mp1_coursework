package com.example.phionah.reda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class ServiceOfferedActivity extends AppCompatActivity {
    RadioButton rdbMoveLagguageOnly, rdbWithLagguage, rdbNoLaguage;
    Button btncontinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_activity);

        initComponents();
    }

    private void initComponents() {

        final String[] strService = {getIntent().getStringExtra("service")};

        rdbMoveLagguageOnly = (RadioButton) findViewById(R.id.rdbMoveLagguageOnly);
        rdbWithLagguage = (RadioButton) findViewById(R.id.rdbWithLagguage);
        rdbNoLaguage = (RadioButton) findViewById(R.id.rdbNoLaguage);

        if (strService[0].equals("Move Lagguage Only")) {
            rdbMoveLagguageOnly.setChecked(true);
        }
        else {
            strService[0].equals("Move with lugguage");
            rdbWithLagguage.setChecked(true);
        }
        if (strService[0].equals("")){
            rdbNoLaguage.setChecked(true);
        }
// Toast.makeText().show;
        Button btnContinue = (Button) findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rdbMoveLagguageOnly.isChecked())
                    strService[0] = "Move Lagguage Only";
                else if(rdbWithLagguage.isChecked())
                    strService[0] = "Move with lugguage";
                else if(rdbNoLaguage.isChecked())
                    strService[0] = "No lagguage";
                else{
                    Toast.makeText(getApplicationContext(), "Select Service!", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent =  new Intent(getApplicationContext(), ServiceOfferedActivity.class);
                startActivity(intent);
            }
        });
    }
}


