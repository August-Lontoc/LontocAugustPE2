package com.lontoc.august;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eFname, eAge, eGender;
    TextView tOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eFname = findViewById(R.id.fullNameEdit);
        eAge = findViewById(R.id.ageEdit);
        eGender = findViewById(R.id.genderEdit);
        tOutput = findViewById(R.id.output);
    }

    public void onSave(View v) {

        SharedPreferences sp = getSharedPreferences("infoData", Context.MODE_PRIVATE);
        SharedPreferences.Editor writer = sp.edit();

        String fname = eFname.getText().toString().trim();
        String age = eAge.getText().toString().trim();
        String gender = eGender.getText().toString().trim();

        writer.putString("fname", fname);
        writer.putString("age", age);
        writer.putString("gender", gender);
        writer.commit();

        Toast.makeText(this, "Data saved...", Toast.LENGTH_SHORT).show();

    }

    public void onSearch(View v) {

        SharedPreferences sp = getSharedPreferences("infoData", Context.MODE_PRIVATE);

        String tvFname = sp.getString("fname", null);
        String tvAge = sp.getString("age", null);
        String tvGender = sp.getString("gender", null);

        String tvOutput = tvFname + "\n" + tvAge + "\n" + tvGender;
        tOutput.setText(tvOutput);
    }
}