package com.Bills.Bills.Management;

import com.Bills.Bills.Auth.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManagementController {
    @Autowired
    private ExpensesServices expensesServices;

    @Autowired
    private JwtUtil jwtUtil;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/loadexpenses")
     public  String loadexpenses(@RequestHeader("Authorization") String authHeader ,@RequestBody Expenses expenses) {
        String ticket = authHeader.substring(7);
        System.out.println(ticket);
        String username = jwtUtil.extractUsername(ticket);
        if (jwtUtil.validateToken(ticket, username)) {
            expensesServices.LoadProfite(expenses);
            return "Done";
        }
        else
        {
            return "Please login agine";
        }
    }

}
