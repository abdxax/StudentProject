package com.example.abdulrahman.studentproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.Toast;

/**
 * Created by Abdulrahman on 26/10/17.
 */

public class SQLquery {
    Context context;
    DBManager dbManager;
    SQLiteDatabase sqLiteDatabase;
    public SQLquery(Context context){
        dbManager=new DBManager(context);
        sqLiteDatabase=dbManager.getWritableDatabase();
        this.context=context;
    }

    public long insertSubject(String title){
        ContentValues values=new ContentValues();
        values.put(DBModel.colsubjectNmae,title);
        long id=sqLiteDatabase.insert(DBModel.DBTableSbject,"",values);

        return id;
    }

    public Cursor listsubkect(String [] Protection,String Selection , String [] SelectionArg,String Order){
        SQLiteQueryBuilder sqLiteQueryBuilder=new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(DBModel.DBTableSbject);
        Cursor cursor=sqLiteQueryBuilder.query(sqLiteDatabase,Protection,Selection,SelectionArg,null,null,Order);

        return cursor;

    }

    public long insertStudent(String name,String cla,String note,String Subject){
        ContentValues values=new ContentValues();
        values.put(DBModel.colstuNmae,name);
        values.put(DBModel.colstuclo,cla);
        values.put(DBModel.colstunote,note);
        values.put(DBModel.ColstuSub,Subject);
      long id=  sqLiteDatabase.insert(DBModel.DBTablestudent,"",values);
        return id;
    }
}
