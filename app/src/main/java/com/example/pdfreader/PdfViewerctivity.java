package com.example.pdfreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class PdfViewerctivity extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewerctivity);

        pdfView=findViewById(R.id.pdfView);


        if (Intent.ACTION_VIEW.equals(getIntent().getAction()) && getIntent().getData() != null) {
            Uri uri = getIntent().getData();
            pdfView.fromUri(uri).load();
        }else{
            File file= (File) getIntent().getSerializableExtra("file");
            pdfView.fromFile(file).load();

        }


    }
}