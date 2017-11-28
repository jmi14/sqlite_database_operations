package com.example.hpfolio.myui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateFriend extends AppCompatActivity {

    EditText etUpdateName, etUpdateEmail;
    Button btnUpdate;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_friend);

        dbHelper = new DBHelper(this);
        etUpdateEmail = (EditText) findViewById(R.id.etEmailUpdate);
        etUpdateName = (EditText) findViewById(R.id.etNameUpdate);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHelper.updateFriend(etUpdateEmail.getText().toString(), etUpdateName.getText().toString());
            }
        });

    }
}
