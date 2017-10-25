package com.example.abdulrahman.studentproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abdulrahman on 26/10/17.
 */

public class DBManager extends SQLiteOpenHelper {
    public DBManager(Context context) {
        super(context,DBModel.DBName,null,DBModel.version);
    }

    //Context context;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBModel.CreateStudentTabel);
        db.execSQL(DBModel.CreateTableSubject);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("Drop Table "+DBModel.DBTablestudent);
        db.execSQL("Drop Table "+DBModel.DBTableSbject);
        onCreate(db);
    }
}
