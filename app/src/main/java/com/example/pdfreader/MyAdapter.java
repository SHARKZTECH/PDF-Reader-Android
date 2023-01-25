package com.example.pdfreader;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Objects;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<File> myfiles;
    Context context;

    public MyAdapter(ArrayList<File> pdfs, Context context) {
        this.myfiles = pdfs;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        File file=myfiles.get(position);
        holder.textView.setText(file.getName());

        holder.itemView.setOnClickListener(view -> {
            if(file.getName().endsWith(".pdf")){
                Intent intent=new Intent(context,PdfViewerctivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("file",file);
                context.startActivity(intent);
            }else if(file.getName().endsWith(".docx")){
                String path=file.getAbsolutePath();
                File file1=new File(path);

                String mime = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                Uri theUri =Uri.fromFile(file1);

                Intent intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_INSTALL_PACKAGE);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                intent.setDataAndType(theUri, mime);

//                context.startActivity(intent);

                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                } else {
                    context.startActivity(Intent.createChooser(intent,"App to open docx not found Choose"));
                }

            }else if (file.getName().endsWith(".pptx")){
                String path=file.getAbsolutePath();
                File file1=new File(path);

                String mime = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
                Uri theUri =Uri.fromFile(file1);

                Intent intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                intent.setDataAndType(theUri, mime);

                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                } else {
                    context.startActivity(Intent.createChooser(intent,"App to open pptx not found Choose"));
                }            }
        });

    }

    @Override
    public int getItemCount() {
        return myfiles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
        }
    }
}
