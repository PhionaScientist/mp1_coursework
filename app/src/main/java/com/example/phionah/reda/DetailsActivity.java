package com.example.phionah.reda;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    EditText etfirstname, etlastname, etemail;
    Button btndetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        initComponents();
    }

    private void initComponents(){
        etfirstname = (EditText)findViewById(R.id.etfirstname);
        etlastname = (EditText)findViewById(R.id.etlastname);
        etemail = (EditText)findViewById(R.id.etemail);
        btndetails = (Button) findViewById(R.id.btndetails);

        btndetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.equals(btndetails)) {
                    String strFirstname, strLastname, strEmail;
                    strFirstname = etfirstname.getText().toString();
                    strLastname = etlastname.getText().toString();
                    strEmail = etemail.getText().toString();

                    if (strFirstname.isEmpty()) {
                        etfirstname.setError("FirstName is Required!");
                        etfirstname.requestFocus();
                        return;
                    }

                    if (strLastname.isEmpty()) {
                        etlastname.setError("LastName is Required");
                        etlastname.requestFocus();
                        return;
                    }

                    if (strEmail.isEmpty()) {
                        etemail.setError("Email is Required");
                        etemail.requestFocus();
                        return;
                    }

                    try {
                        DatabaseHandler dh = new DatabaseHandler(getApplicationContext());

                        ContentValues values = new ContentValues();

                        values.put(Database.User.Phone, strFirstname);
                        values.put(Database.User.Phone, strLastname);
                        values.put(Database.User.Phone, strEmail);

                        dh.insert(Database.User.NAME, values);

                        Toast.makeText(getApplicationContext(), " Saved Successfully!", Toast.LENGTH_SHORT).show();

                        etfirstname.setText("");
                        etlastname.setText("");
                        etemail.setText("");

                        Intent logindetails = new Intent(getApplicationContext(), ServiceOfferedActivity.class);
                        startActivity(logindetails);

                    }catch (Exception ex){
                        Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    Intent myIntent = new Intent(getApplicationContext(), ServiceOfferedActivity.class);
                    startActivity(myIntent);
                }
            }
        });
    }
}

