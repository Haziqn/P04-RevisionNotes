package com.myapplicationdev.android.p04_revisionnotes;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
	ListView lv;
	ArrayList<Note> notes = new ArrayList<>();
	RevisionNotesArrayAdapter aaToDo;
	DBHelper myDb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		lv = (ListView)findViewById(R.id.lv);
		myDb = new DBHelper(SecondActivity.this);
		notes = myDb.getAllNotes();
		Toast.makeText(SecondActivity.this, notes.size() + "", Toast.LENGTH_LONG).show();
		aaToDo = new RevisionNotesArrayAdapter(this, R.layout.row, notes);
		lv.setAdapter(aaToDo);
		aaToDo.notifyDataSetChanged();

	}


}
