package com.example.phionah.reda;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login1Activity extends AppCompatActivity {

    private EditText etPhone;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        initComponents();

    }

    private void initComponents() {

        etPhone = (EditText) findViewById(R.id.etPhone);
        btnContinue = (Button) findViewById(R.id.btnContinue);

        final Button btnContinue = (Button)findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (v.equals(btnContinue)) {
                    String strPhone ;
                    strPhone = etPhone.getText().toString();

                    if (strPhone.isEmpty()){
                        etPhone.setError("Phone is Required");
                        etPhone.requestFocus();
                        return;
                    }

                    try {
                        DatabaseHandler dh = new DatabaseHandler(getApplicationContext());

                        ContentValues values = new ContentValues();

                        values.put(Database.User.Phone, strPhone);

                        dh.insert(Database.User.NAME, values);

                        Toast.makeText(getApplicationContext(), "Saved Successfully!", Toast.LENGTH_SHORT).show();

                        etPhone.setText("");

                        Intent logindetails = new Intent(getApplicationContext(), DetailsActivity.class);
                        startActivity(logindetails);

                    }catch (Exception ex){
                        Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}


