package com.example.spendwise;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ArrayAdapter;

public class AddExpenseActivity extends AppCompatActivity {

    // UI Elements
    EditText etAmount, etNote;
    Spinner spinnerCategory;
    Button btnSave;

    // Database Helper
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        // UI Elements හොයාගන්නවා
        etAmount = findViewById(R.id.etAmount);
        etNote = findViewById(R.id.etNote);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        btnSave = findViewById(R.id.btnSave);

        // Database එක හදනවා
        dbHelper = new DatabaseHelper(this);

        // Category Spinner එකට අයිතම දානවා (Food, Transport, Bills)
        String[] categories = {"Food", "Transport", "Bills", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        // Save Button එක ඔබද්දී වෙන දේ
        btnSave.setOnClickListener(v -> {
            String amountStr = etAmount.getText().toString().trim();
            String note = etNote.getText().toString().trim();
            String category = spinnerCategory.getSelectedItem().toString();

            if (amountStr.isEmpty()) {
                Toast.makeText(AddExpenseActivity.this, "Please enter an amount", Toast.LENGTH_SHORT).show();
                return;
            }

            double amount = Double.parseDouble(amountStr);
            dbHelper.addExpense(amount, category, note); // මේ පේළිය තියෙන්න ඕනේ
            Toast.makeText(AddExpenseActivity.this, "Expense Saved!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}