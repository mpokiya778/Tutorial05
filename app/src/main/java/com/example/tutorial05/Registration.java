package com.example.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

public class Registration extends AppCompatActivity {

    Button btnRegister;
    EditText edtName;
    EditText edtlname;
    EditText edtemail;
    EditText edtpswd;
    Switch swhBranch;
    Spinner spnCountries;
    CheckBox chckStatus;
    RadioGroup rdgrp;
    RadioButton rdgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnRegister = findViewById(R.id.btnRegister);
        edtName = findViewById(R.id.edtFname);
        edtlname = findViewById(R.id.edtLname);
        edtemail = findViewById(R.id.edtUsername);
        edtpswd = findViewById(R.id.edtpsd);
        swhBranch = findViewById(R.id.swchBranch);
        spnCountries = findViewById(R.id.spnCity);
        chckStatus = findViewById(R.id.chkStatus);
        rdgrp  = findViewById(R.id.rdgrp);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = rdgrp.getCheckedRadioButtonId();
                rdgender = findViewById(id);
                String firstname = edtName.getText().toString();
                String lastname = edtlname.getText().toString();
                String username = edtemail.getText().toString();
                String password = edtpswd.getText().toString();
                String country = spnCountries.getSelectedItem().toString();
                String status = "";
                String branch = "";
                String gender = rdgender.getText().toString();
                if (swhBranch.isChecked())
                {
                    branch = swhBranch.getTextOn().toString();
                }
                else
                {
                    branch = swhBranch.getTextOff().toString();
                }
                if(chckStatus.isChecked())
                {
                    status = "Active";
                }
                else
                {
                    status = "Inactive";
                }

                Intent i = new Intent(Registration.this,MainActivity.class);
                i.putExtra("firstname",firstname);
                i.putExtra("lastname",lastname);
                i.putExtra("username",username);
                i.putExtra("password",password);
                i.putExtra("country",country);
                i.putExtra("status",status);
                i.putExtra("branch",branch);
                i.putExtra("gender",gender);
                startActivity(i);
            }
        });
    }
}