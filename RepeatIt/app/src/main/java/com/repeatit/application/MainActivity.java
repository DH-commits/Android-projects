package com.repeatit.application;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

    private Button addButton, editButton, deleteButton;
    private String TAG = "MainActivity: ";
    private ArrayList<String> tasksArrayList = new ArrayList<String>();
    private ArrayList<String> tasksContentList = new ArrayList<String>();
    private ArrayList<String> editContentList = new ArrayList<String>();
    private ListView listView;
    private CustomArrayAdapter customArrayAdapter;
    private String buttonClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readSavedTasks(tasksArrayList);

        editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: editButtonOnClick");
                buttonClicked = "editButton";
                Intent addTaskActivity = new Intent(MainActivity.this, AddTaskActivity.class);
                addTaskActivity.putExtra("BUTTON_CLICKED", buttonClicked);
                startActivity(addTaskActivity);
            }
        });
        deleteButton = findViewById(R.id.deleteButton);
        
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: deleteButtonOnClick");
            }
        });
        addButton = findViewById(R.id.newButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = "addButton";
                Intent addTaskActivity = new Intent(MainActivity.this, AddTaskActivity.class);
                addTaskActivity.putExtra("BUTTON_CLICKED", buttonClicked);
                startActivity(addTaskActivity);
                Log.d(TAG, "onClick: Loading new activity -> addTaskActivity");
            }
        });

        // Set an item click listener for ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);

                //read file storing each line into a variable
                String url, description, duration = "";


                    loadURL(selectedItem, tasksContentList);

                //loadDataIntoListItem(selectedItem, tasksContentList);




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

    private void loadDataIntoListItem(String selectedItem, ArrayList<String> arrayList){
        FileInputStream fis = null;
        Context context = getApplicationContext();
        try {
            fis = context.openFileInput( selectedItem + ".txt");
            Log.d(TAG, "onItemClick: " + selectedItem + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                arrayList.add(line);
                sb.append(line).append("\n");
            }
            fis.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        String result = sb.toString();
        String url = arrayList.get(1);
        String duration = arrayList.get(2);
        String description = arrayList.get(3);
    }

    private void loadURL(String taskName, ArrayList<String> tasksContent){
        Context context = getApplicationContext();
        FileInputStream fis = null;
        try {
            Log.d(TAG, "loadURL: looking for file " + taskName + ".txt" );
            fis = context.openFileInput( taskName);//+".txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                Log.d(TAG, "readSavedTasks: " + line);
                tasksContent.add(line);
                sb.append(line).append("\n");
            }
            fis.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }

        String url = tasksContentList.get(1);
        Log.d(TAG, "loadURL: the string at index 1 is:" + url);
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

    }




    }


