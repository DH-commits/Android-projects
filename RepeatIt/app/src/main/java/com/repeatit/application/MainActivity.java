package com.repeatit.application;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private String TAG = "MainActivity: ";
    private ArrayList<String> tasksArrayList = new ArrayList<String>();
    private ListView listView;
    private CustomArrayAdapter customArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        readSavedTasks(tasksArrayList);

        addButton = findViewById(R.id.newButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addTaskActivity = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(addTaskActivity);
                Log.d(TAG, "onClick: Loading new activity -> addTaskActivity");
            }
        });

    }


    /*Check if savedTasks file exists,
       * if it doesn't exist - return
           otherwise
       *  read each line of the savedTasks file and store into an arrayList
       * */
    private void readSavedTasks(ArrayList<String> tasksArrayList){
        Context context = getApplicationContext();
        //FileInputStream fis = null;
        FileInputStream fis = null;
        try {
            fis = context.openFileInput("savedTasks.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                Log.d(TAG, "readSavedTasks: " + line);
                tasksArrayList.add(line);
                sb.append(line).append("\n");
            }
            fis.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        String result = sb.toString();
        Log.d(TAG, "readSavedTasks: Result: " + result);
        customArrayAdapter = new CustomArrayAdapter(this, tasksArrayList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(customArrayAdapter);

    }


    }


