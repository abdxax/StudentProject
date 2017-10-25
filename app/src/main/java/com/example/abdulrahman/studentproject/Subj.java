package com.example.abdulrahman.studentproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Abdulrahman on 26/10/17.
 */

public class Subj extends DialogFragment implements View.OnClickListener {

EditText sub;
    Button sa;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=inflater.inflate(R.layout.addsubject,container,false);
        sub=(EditText) view1.findViewById(R.id.editText4);
        sa=(Button) view1.findViewById(R.id.button4);
        sa.setOnClickListener(this);
        return view1;
    }

    @Override
    public void onClick(View v) {
        this.dismiss();
        MainActivity mainActivity=(MainActivity) getActivity();
        mainActivity.saveSub(sub.getText().toString());
    }
}
