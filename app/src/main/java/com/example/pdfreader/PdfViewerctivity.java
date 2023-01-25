package com.example.pdfreader;

import androidx.appcompat.app.AppCompatActivity;

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

        File file= (File) getIntent().getSerializableExtra("file");
        pdfView.fromFile(file).load();
        pdfView.setBackground(getDrawable(R.drawable.ic_pdf));

    }
}