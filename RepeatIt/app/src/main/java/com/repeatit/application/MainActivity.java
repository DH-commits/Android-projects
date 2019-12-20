package com.repeatit.application;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button addButton = findViewById(R.id.button);
    private String TAG = "MainActivity: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addTaskActivity = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(addTaskActivity);
                Log.d(TAG, "onClick: Loading new activity -> addTaskActivity");
            }
        });

    }
}
