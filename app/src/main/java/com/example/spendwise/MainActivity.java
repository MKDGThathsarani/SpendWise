package com.example.spendwise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fabAddExpense;
    TextView tvTotalAmount;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fabAddExpense = findViewById(R.id.fabAddExpense);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        dbHelper = new DatabaseHelper(this);

        // Add Expense බොත්තම ඔබද්දී අලුත් තිරයට යනවා
        fabAddExpense.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
            startActivity(intent);
        });
    }

    // App එකට ආයෙත් එනකොට (Save කරලා ආවම) අලුත් දත්ත ලෝඩ් කරනවා
    @Override
    protected void onResume() {
        super.onResume();
        loadExpenses();
    }

    private void loadExpenses() {
        List<Expense> expenseList = dbHelper.getAllExpenses();

        ExpenseAdapter adapter = new ExpenseAdapter(expenseList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        double total = 0;
        for (Expense expense : expenseList) {
            total += expense.getAmount();
        }
        tvTotalAmount.setText("Rs. " + String.format("%.2f", total));
    }
}