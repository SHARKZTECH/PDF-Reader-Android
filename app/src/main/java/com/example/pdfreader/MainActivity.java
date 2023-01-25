package com.example.pdfreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {
    MaterialCardView pdf,docs,pttx,ptt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdf=findViewById(R.id.pdfs);
        docs=findViewById(R.id.docs);
        pttx=findViewById(R.id.ptx);
        ptt=findViewById(R.id.ppt);

        pdf.setOnClickListener(view -> {
            startActivity(new Intent(this,PdfActivity.class));
        });
        
        docs.setOnClickListener(view -> {
            startActivity(new Intent(this,DocActivity.class));
        });
    }
}