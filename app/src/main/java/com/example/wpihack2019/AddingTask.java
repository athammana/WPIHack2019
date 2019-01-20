package com.example.wpihack2019;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class AddingTask extends AppCompatActivity {

    TaskDBHandler taskDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_task);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        taskDB = new TaskDBHandler(this, null, null, 1);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ImageButton addTaskButton = (ImageButton) findViewById(R.id.AddTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText taskName = (EditText) findViewById(R.id.AddTaskNameInput);
                EditText taskMinTime = (EditText) findViewById(R.id.AddTaskMinInput);
                EditText taskMaxTime = (EditText) findViewById(R.id.AddTaskMaxInput);
                EditText taskPriority = (EditText) findViewById(R.id.AddTaskPriorityInput);
                TextView resultText = (TextView) findViewById(R.id.resultTextView);

                String name = taskName.getText().toString();
                double minTime = Double.parseDouble(taskMinTime.getText().toString());
                double maxTime = Double.parseDouble(taskMaxTime.getText().toString());
                int priority = Integer.parseInt(taskPriority.getText().toString());
                Task task = new Task(0, name, priority, 0, minTime, maxTime);
                taskDB.addTask(task);
//                resultText.setText(minTime + "," + maxTime + "," + priority + "," + name);

            }
        });

    }
}

