package com.example.wpihack2019;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.os.Build;

public class TaskDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "routines_and_tasks.db";
    public static final String TABLE_TASKS = "tasks";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TASKNAME = "taskname";
    public static final String COLUMN_PRIORITY = "priority";
    public static final String COLUMN_MINMINS = "minmins";
    public static final String COLUMN_MAXMINS = "maxmins";
    public static final String [] COLUMNS = {COLUMN_ID, COLUMN_TASKNAME, COLUMN_PRIORITY, COLUMN_MINMINS, COLUMN_MAXMINS};

    public TaskDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_TASKS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TASKNAME + " TEXT, " +
                COLUMN_MINMINS + " FLOAT, " +
                COLUMN_MAXMINS + " FLOAT, " +
                COLUMN_PRIORITY + " INTEGER " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void addTask(Task task){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASKNAME, task.getName());
        values.put(COLUMN_MINMINS, task.getMinMins());
        values.put(COLUMN_MAXMINS, task.getMaxMins());
        values.put(COLUMN_PRIORITY, task.getPriority());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_TASKS, null, values);
        db.close();
    }

    public Task getTask(int taskId){
        SQLiteDatabase db = getWritableDatabase();

        Cursor c = db.query(TABLE_TASKS, COLUMNS, COLUMN_ID + " = " + taskId, null, null, null, null);
        db.close();

        Task task = new Task(c.getInt(c.getColumnIndex(COLUMN_ID)), c.getString(c.getColumnIndex(COLUMN_TASKNAME)),
                c.getInt(c.getColumnIndex(COLUMN_PRIORITY)), 0, c.getInt(c.getColumnIndex(COLUMN_MINMINS)),
                c.getInt(c.getColumnIndex(COLUMN_MAXMINS)));

        return task;
    }
}
