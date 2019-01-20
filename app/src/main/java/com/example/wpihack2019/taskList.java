package com.example.wpihack2019;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class taskList extends AppCompatActivity {

    int [] IMAGES = {R.drawable.toothbrush, R.drawable.showering, R.drawable.poopemoji, R.drawable.breakfast, R.drawable.yoga};
    //    int [] IMAGES = {R.drawable.morningagain, R.drawable.morningagain, R.drawable.morningagain, R.drawable.morningagain, R.drawable.morningagain};
    String [] TASK_NAMES = {"Brushing Teeth", "Taking a Shower", "Using the Toilet", "Cooking Eggs", "Doing Yoga"};
    //String [] ROUTINE_TASKS = {"Shower, Brush Teeth, Put on Clothes, Lock Door", "Shower, Brush Teeth, Put on Clothes, Lock Door", "Study, Break. Study",
    //        "Thaw Chicken, Heat pans, Put pasta in pot, Cook chicken, Plate", "Get in Bed"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView);

        CustomTaskAdapter customTaskAdapter = new CustomTaskAdapter();
        listView.setAdapter(customTaskAdapter);

    }

    class CustomTaskAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return TASK_NAMES.length;
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

            convertView = getLayoutInflater().inflate(R.layout.tasklayout, null);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewTask);
            TextView textView_name = (TextView) convertView.findViewById(R.id.taskTitle);

            imageView.setImageResource(IMAGES[position]);
            textView_name.setText(TASK_NAMES[position]);

            return convertView;
        }
    }

}
