package com.example.hpfolio.myui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteFriend extends AppCompatActivity {

    EditText etEmailEdit;
    Button btnDelete;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_friend);

        dbHelper = new DBHelper(this);
        etEmailEdit = (EditText) findViewById(R.id.etEmailEdit);
        btnDelete = (Button) findViewById(R.id.btnDel);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHelper.deleteFriend(etEmailEdit.getText().toString());

            }
        });
    }
}
