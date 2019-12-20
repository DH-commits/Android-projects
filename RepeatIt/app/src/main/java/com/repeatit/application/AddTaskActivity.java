package com.repeatit.application;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddTaskActivity extends AppCompatActivity {

    private EditText titleText, urlText, durationText, notesText;
    private Button cancelButton, saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        titleText = findViewById(R.id.titleText);
        urlText = findViewById(R.id.urlText);
        durationText = findViewById(R.id.durationText);
        notesText = findViewById(R.id.notesText);
        cancelButton = findViewById(R.id.cancelButton);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(titleText.getText().toString().equals("")){
                    Toast.makeText(AddTaskActivity.this, "You must enter a title", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    String FILENAME = titleText.getText().toString();
                    String url = urlText.getText().toString();
                    String duration = durationText.getText().toString();
                    String notes = notesText.getText().toString();

                    FileOutputStream fos = null;
                    try {
                        fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        fos.write(FILENAME.getBytes());
                        fos.write(url.getBytes());
                        fos.write(duration.getBytes());
                        fos.write(notes.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(AddTaskActivity.this, " " + FILENAME + " was added to Task list.", Toast.LENGTH_SHORT).show();
                }

            }
            
        });
    }
}
