package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText editTextNote;
    Button buttonInsert, buttonShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNote = (EditText)findViewById(R.id.editTextNote);
        buttonShow = (Button)findViewById(R.id.buttonShowList);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        buttonInsert = (Button)findViewById(R.id.buttonInsertNote);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroupStars);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                String noteContent = editTextNote.getText().toString();
                int star = Integer.parseInt(rb.getText().toString());

                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertNote(noteContent, star);
                db.close();
            }
        });
    }
}
