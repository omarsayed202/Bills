package com.Bills.Bills.Items;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Item") // Adjust table name as necessary
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true ,columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci")
    private String Name;
    private  long count;
    private  double ItemPrice;
    private double Buying;
    private double Saleing;
    private double profit;
    private LocalDate date;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double itemPrice) {
        ItemPrice = itemPrice;
    }

    public double getBuying() {
        return Buying;
    }

    public void setBuying(double buying) {
        Buying = buying;
    }

    public double getSaleing() {
        return Saleing;
    }

    public void setSaleing(double saleing) {
        Saleing = saleing;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
