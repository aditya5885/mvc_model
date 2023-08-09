package com.example.mvc_model;
//pojo class in java (plain old java object)  used for getter and setter ,freindly , vector in java
//iterators or enumeratoins ,arraylist is a collection of storing user defiend and predefined datatypes
//cursor- 4 operations- why - execeptions-create obj,open,fetch,close,snapshot,view,difference btw view and cursor storing instance
//string is immutable string helllo,string hi print cheyumbol hi ,but hello is stored somewhere in memory
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity<str> extends AppCompatActivity {

    EditText e1,e2;
    CDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        db=new CDB(this);

    }

    public void Find(View view) {
        String a[];

    }

    public void save(View view) {
        CDept rec=new CDept();
        rec.dname=e1.getText().toString();
        rec.dloc=e2.getText().toString();
        db.addDept(rec);
        e1.setText("");
        e2.setText("");
    }

    public void List(View view) {
        List<CDept> rec=db.getAllvalues();
        String str="";
        for(CDept cr:rec){
            String log="Did:"+ cr.id+",DNAME:"+cr.dname+",DLOC:"+cr.dloc;
            log=log+"\n";
            str=str+log;
        }
    TextView t=(TextView)findViewById(R.id.tv);
    t.setText(str);
}}