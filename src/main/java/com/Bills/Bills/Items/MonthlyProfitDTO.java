package com.Bills.Bills.Items;

import java.math.BigDecimal;

public class MonthlyProfitDTO {

    private int Month;
    private BigDecimal profit;

    public MonthlyProfitDTO(int month, BigDecimal profit) {
        this.Month = month;
        this.profit = profit;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        this.Month = month;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }
}
