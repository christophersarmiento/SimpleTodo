package com.csarmiento.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

  EditText etEditItem;
  Button btnSave;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit);

    etEditItem = findViewById(R.id.etEditItem);
    btnSave = findViewById(R.id.btnSave);

    getSupportActionBar().setTitle("Edit Item");

    etEditItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

    btnSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Create an intent which will contain the results
        Intent intent = new Intent();
        // Pass the data (results of editing)
        intent.putExtra(MainActivity.KEY_ITEM_TEXT, etEditItem.getText().toString());
        intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
        // Set the result of the intent
        setResult(RESULT_OK, intent);
        // Finish the activity and return
        finish();
      }
    });
  }
}