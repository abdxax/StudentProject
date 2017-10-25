package com.example.abdulrahman.studentproject;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sav(View view) {
        FragmentManager fragmentManager=getSupportFragmentManager();
       SyudentAd syudentAd=new SyudentAd(this);
        syudentAd.show(fragmentManager,"Add student ");

    }

    public void display(String name,String clas,String note,String subject){

        SQLquery sq=new SQLquery(this);
        long id=sq.insertStudent(name,clas,note,subject);
        Toast.makeText(this,"The id is "+id,Toast.LENGTH_LONG).show();

    }

    public void saveSub(String ti){
        SQLquery sqLquery=new SQLquery(this);
        long id=sqLquery.insertSubject(ti);
        Toast.makeText(this,ti+" id is "+id,Toast.LENGTH_LONG).show();
    }

    public void savsub(View view) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        Subj subj=new Subj();
        subj.show(fragmentManager,"ADD SUBJECT ");
    }

    public void edditsubject(View view) {

    }
}
