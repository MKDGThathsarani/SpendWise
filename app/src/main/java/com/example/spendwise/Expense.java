package com.example.spendwise;

public class Expense {
    private int id;
    private double amount;
    private String category;
    private String note;

    public Expense() {
    }

    public Expense(int id, double amount, String category, String note) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.note = note;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}