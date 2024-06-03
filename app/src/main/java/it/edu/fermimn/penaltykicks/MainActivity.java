package it.edu.fermimn.penaltykicks;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class  MainActivity extends AppCompatActivity {

    private static int goals = 0;

    private static TextView goalText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goalText = findViewById(R.id.goals);
        goalText.setText("Goals: 0");
    }

    public static void addGoal() {
        goals++;
        goalText.setText("Goals: " + goals);
    }
}