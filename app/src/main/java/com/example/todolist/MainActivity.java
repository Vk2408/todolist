package com.example.todolist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import  androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button add;
    AlertDialog d;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.b1);
        l = findViewById(R.id.container);
        buildDialog();
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                d.show();
            }
        });
    }

    public void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog, null);
        final EditText name = view.findViewById(R.id.edt);
        builder.setView(view);
        builder.setTitle("Enter your task").setPositiveButton("SAVE", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addCard(name.getText().toString());
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        d = builder.create();

    }

    private void addCard(String name) {
        final View view = getLayoutInflater().inflate(R.layout.card, null);
        TextView nameview = view.findViewById(R.id.text);
        Button btn = view.findViewById(R.id.btn);
        nameview.setText(name);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l.removeView(view);
            }

        });
        l.addView(view);
    }
}