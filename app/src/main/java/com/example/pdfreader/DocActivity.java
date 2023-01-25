package com.example.pdfreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;

public class DocActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        recyclerView=findViewById(R.id.recycler);

        ArrayList<File> files=getPdfs(Environment.getExternalStorageDirectory());
        myAdapter=new MyAdapter(files,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
    public ArrayList<File> getPdfs(File file){
        ArrayList<File> arrayList=new ArrayList<>();
        File[] files=file.listFiles();
        for(File singleFile:files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                arrayList.addAll(getPdfs(singleFile));
            }else {
                if(singleFile.getName().endsWith(".docx")){
                    arrayList.add(singleFile);
                }
            }
        }
        return arrayList;
    }
}