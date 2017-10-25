package com.example.abdulrahman.studentproject;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdulrahman on 25/10/17.
 */

public class SyudentAd extends DialogFragment implements View.OnClickListener {
    Context context;

    public SyudentAd (Context context){
        this.context=context;
    }
EditText name,clas,note;
    Spinner subject;
    Button save;
    String tit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=inflater.inflate(R.layout.addstu,container,false);
        name=(EditText) view1.findViewById(R.id.editText);
        clas=(EditText) view1.findViewById(R.id.editText2);
        note=(EditText) view1.findViewById(R.id.editText3);
        subject=(Spinner) view1.findViewById(R.id.spinner);
        save=(Button) view1.findViewById(R.id.button);
        save.setOnClickListener(this);
        List<String> Subj=new ArrayList<String>();
      //  String []subop=new String[Subj.size()];
        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Subj);
           SQLquery sqLquery=new SQLquery(context);
        Cursor cursor=sqLquery.listsubkect(null,null,null,DBModel.colsubjectNmae);
        if (cursor.moveToFirst()){
            do {
                Subj.add(cursor.getString(cursor.getColumnIndex(DBModel.colsubjectNmae)));
            }while (cursor.moveToNext());
        }
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, Subj);
        subject.setAdapter(dataAdapter);
        subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tit=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view1;
    }

    @Override
    public void onClick(View v) {
        this.dismiss();
MainActivity mainActivity=(MainActivity)getActivity();
        mainActivity.display(name.getText().toString(),clas.getText().toString(),note.getText().toString(),tit);
    }
}
