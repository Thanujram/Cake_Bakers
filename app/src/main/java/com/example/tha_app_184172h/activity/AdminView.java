package com.example.tha_app_184172h.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tha_app_184172h.R;
import com.example.tha_app_184172h.services.DatabaseHelper;

public class AdminView extends AppCompatActivity {
    final Context context = this;

    DatabaseHelper db = new DatabaseHelper(AdminView.this);
    Button Add_Btn,Update_Btn,Delete_btn,View_Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);
        Add_Btn= findViewById(R.id.add_btn);
        Update_Btn = findViewById(R.id.update_btn);
        Delete_btn = findViewById(R.id.delete_btn);
        View_Btn = findViewById(R.id.view_btn);
        View_Btn.setOnClickListener(v -> {


            Cursor res = db.getItemDetails();
            if (res.getCount() == 0) {
                showMessage("Item", "There are no items added");
                return;
            }
            StringBuilder buffer = new StringBuilder();
            while (res.moveToNext()) {
                buffer.append("Id:").append(res.getString(0)).append("\n");
                buffer.append("name:").append(res.getString(1)).append("\n");
                buffer.append("des:").append(res.getString(2)).append("\n");
                buffer.append("price:").append(res.getString(3)).append("\n").append("\n");
            }
            showMessage("Items", buffer.toString());
            Log.d("RESULTTTTTTTTTTTTTTTT", buffer.toString());
        });
        Add_Btn.setOnClickListener(v -> {
            LayoutInflater li = LayoutInflater.from(context);
            View promptsView = li.inflate(R.layout.add_layout, null);
            EditText item_name = promptsView.findViewById(R.id.add_item_name);
            EditText item_des = promptsView.findViewById(R.id.add_item_des);
            EditText item_price = promptsView.findViewById(R.id.add_item_price);
            Button Add = promptsView.findViewById(R.id.layout_add_btn);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(promptsView);

            Add.setOnClickListener(v1 -> {
                if (TextUtils.isEmpty(item_name.getText().toString()) || TextUtils.isEmpty(item_des.getText().toString()) || TextUtils.isEmpty(item_price.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please Enter Valid data!", Toast.LENGTH_SHORT).show();
                } else {
                    db.addItem(item_name.getText().toString(), item_des.getText().toString(), item_price.getText().toString());
                    Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_SHORT).show();
                    item_name.setText("");
                    item_des.setText("");
                    item_price.setText("");
                }
            });
            // set dialog message
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            (dialog, id) -> {
                                // get user input and set it to result
                                // edit text


                            })
                    .setNegativeButton("Cancel",
                            (dialog, id) -> dialog.cancel());

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();

        });
        Update_Btn.setOnClickListener(v -> {
            LayoutInflater li = LayoutInflater.from(context);
            View promptsView = li.inflate(R.layout.update_layout, null);
            EditText update_item_name = promptsView.findViewById(R.id.update_item_name);
            EditText update_item_des = promptsView.findViewById(R.id.update_item_des);
            EditText update_item_price = promptsView.findViewById(R.id.update_item_price);
            Button Update = promptsView.findViewById(R.id.layout_update_btn);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(promptsView);
            Update.setOnClickListener(v1 -> {
                if (TextUtils.isEmpty(update_item_name.getText().toString()) || TextUtils.isEmpty(update_item_des.getText().toString()) || TextUtils.isEmpty(update_item_price.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please Enter Valid data!", Toast.LENGTH_SHORT).show();
                } else {
                    db.updateItem(update_item_name.getText().toString(), update_item_des.getText().toString(), update_item_price.getText().toString());
                    Toast.makeText(getApplicationContext(), "Item Updated", Toast.LENGTH_SHORT).show();
                    update_item_name.setText("");
                    update_item_des.setText("");
                    update_item_price.setText("");
                }
            });
            // set dialog message
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            (dialog, id) -> {
                                // get user input and set it to result
                                // edit text



                            })
                    .setNegativeButton("Cancel",
                            (dialog, id) -> dialog.cancel());

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();


        });
        Delete_btn.setOnClickListener(v -> {
            LayoutInflater li = LayoutInflater.from(context);
            View promptsView = li.inflate(R.layout.delete_layout, null);
            EditText delete_item_name = promptsView.findViewById(R.id.delete_item_name);
            Button Delete  = promptsView.findViewById(R.id.layout_delete_btn);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(promptsView);
            Delete.setOnClickListener(v1 -> {
                if (TextUtils.isEmpty(delete_item_name.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please Enter Invalid data!", Toast.LENGTH_SHORT).show();
                } else {
                    db.deleteItem(delete_item_name.getText().toString());
                    Toast.makeText(getApplicationContext(), "Item Deleted", Toast.LENGTH_SHORT).show();
                    delete_item_name.setText("");
                }
            });
            // set dialog message
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            (dialog, id) -> {
                                // get user input and set it to result
                                // edit text



                            })
                    .setNegativeButton("Cancel",
                            (dialog, id) -> dialog.cancel());

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        });

    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}