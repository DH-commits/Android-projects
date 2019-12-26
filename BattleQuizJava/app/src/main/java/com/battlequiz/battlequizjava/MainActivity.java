package com.battlequiz.battlequizjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {

    private FancyButton quickplayButton, matchButton, leaderboardButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quickplayButton = findViewById(R.id.quickplayButton);
        matchButton = findViewById(R.id.matchupButton);
        leaderboardButton = findViewById(R.id.leaderboardButton);

        quickplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(quiz);
            }
        });

    }
}
