package com.example.spendwise;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // අපේ කොළ පාට Add බොත්තම (FAB) හොයාගන්නවා
        FloatingActionButton fabAddExpense = findViewById(R.id.fabAddExpense);

        // බොත්තම එබුවම මොකද වෙන්නේ කියලා කියනවා
        fabAddExpense.setOnClickListener(v -> {
            // අලුත් තිරයට යන්න Intent එකක් හදනවා
            Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
            startActivity(intent);
        });
    }
}