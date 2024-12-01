package com.Bills.Bills.Management;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
   private int id ;
    @Column
    private LocalDate date;
    @Column
    double expenses;
    public Expenses(LocalDate date, double expenses) {
        this.date = date;
        this.expenses =expenses;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate month) {
        this.date = month;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

}
