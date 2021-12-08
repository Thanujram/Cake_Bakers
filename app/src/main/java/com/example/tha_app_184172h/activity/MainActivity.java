package com.example.tha_app_184172h.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.tha_app_184172h.R;

public class MainActivity extends AppCompatActivity {
Button Admin_View_Btn, Editable_View_Btn;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Admin_View_Btn=findViewById(R.id.admin_view_Btn);
        Editable_View_Btn =findViewById(R.id.editable_view_Btn);
        Admin_View_Btn.setOnClickListener(v -> {
            Intent AdminView = new Intent(this, AdminView.class);
            startActivity(AdminView);
        });
        Editable_View_Btn.setOnClickListener(v -> {
            Intent EditableView = new Intent(this, EditableView.class);
            startActivity(EditableView);
        });


    }
}