package com.example.spendwise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private List<Expense> expenseList;

    public ExpenseAdapter(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // item_expense.xml එක ලෝඩ් කරනවා
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expense, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Expense expense = expenseList.get(position);

        // දත්ත ටික ලැයිස්තුවේ කොටුවලට දානවා
        holder.tvItemCategoryNote.setText(expense.getCategory() + " - " + expense.getNote());
        holder.tvItemAmount.setText("Rs. " + String.format("%.2f", expense.getAmount()));
        holder.tvItemDate.setText("Today");
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemCategoryNote, tvItemAmount, tvItemDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemCategoryNote = itemView.findViewById(R.id.tvItemCategoryNote);
            tvItemAmount = itemView.findViewById(R.id.tvItemAmount);
            tvItemDate = itemView.findViewById(R.id.tvItemDate);
        }
    }
}