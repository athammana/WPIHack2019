package com.example.wpihack2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class routineList extends AppCompatActivity {

    int [] IMAGES = {R.drawable.elmobrushing, R.drawable.morningagain, R.drawable.studying, R.drawable.cooking, R.drawable.bed};
//    int [] IMAGES = {R.drawable.morningagain, R.drawable.morningagain, R.drawable.morningagain, R.drawable.morningagain, R.drawable.morningagain};
    String [] ROUTINE_NAMES = {"Monday and Thursday Morning", "Tuesday and Friday Morning", "Studying", "Dinner Prep", "Bed Prep"};
    String [] ROUTINE_TASKS = {"Shower, Brush Teeth, Put on Clothes, Lock Door", "Shower, Brush Teeth, Put on Clothes, Lock Door", "Study, Break. Study",
                                "Thaw Chicken, Heat pans, Put pasta in pot, Cook chicken, Plate", "Get in Bed"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

//        configureBackButton();
    }

//    private void configureBackButton(){
//        Button backButton = (Button) findViewById(R.id.next_button);
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return ROUTINE_NAMES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.routinelayout, null);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            TextView textView_name = (TextView) convertView.findViewById(R.id.textView_name);
            TextView textView_tasks = (TextView) convertView.findViewById(R.id.textView_tasks);

            imageView.setImageResource(IMAGES[position]);
            textView_name.setText(ROUTINE_NAMES[position]);
            textView_tasks.setText(ROUTINE_TASKS[position]);


            return convertView;
        }
    }

}
