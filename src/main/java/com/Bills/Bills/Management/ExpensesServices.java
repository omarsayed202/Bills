package com.Bills.Bills.Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpensesServices {
    @Autowired
    ExpensesRepository expensesRepository;
    void LoadProfite(Expenses expenses)
    {
        expensesRepository.save(expenses);
    }


}
