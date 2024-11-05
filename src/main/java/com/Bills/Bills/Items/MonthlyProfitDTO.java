package com.Bills.Bills.Items;

import java.math.BigDecimal;

public class MonthlyProfitDTO {

    private int Month;
    private Double profit;

    public MonthlyProfitDTO(int month, Double profit) {
        this.Month = month;
        this.profit = profit;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        this.Month = month;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }
}
