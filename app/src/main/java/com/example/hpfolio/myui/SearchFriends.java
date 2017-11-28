package com.example.hpfolio.myui;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchFriends extends AppCompatActivity {

    Button btnSearch;
    EditText etSearch;
    DBHelper dbHelper;
    TextView tvEmail, tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        dbHelper = new DBHelper(this);
        etSearch = (EditText) findViewById(R.id.etSearch);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvName = (TextView) findViewById(R.id.tvName);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor c = dbHelper.getFriends(etSearch.getText().toString());
                while (c.moveToNext()) {

                    int nameIndex = c.getColumnIndex("name");
                    int emailIndex = c.getColumnIndex("email");
                    tvEmail.setText(c.getString(emailIndex));
                    tvName.setText(c.getString(nameIndex));

                }

            }
        });

    }
}
