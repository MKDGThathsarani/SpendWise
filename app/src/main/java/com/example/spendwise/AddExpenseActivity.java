package com.example.spendwise;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class AddExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            finish();
        });
    }
}