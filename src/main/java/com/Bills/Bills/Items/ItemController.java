package com.Bills.Bills.Items;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.Bills.Bills.Auth.JwtUtil;
import com.Bills.Bills.Auth.MyUserDetailsService;
import com.Bills.Bills.Auth.UserRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemServices itemServices;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/additem")
        public  String add(@RequestHeader("Authorization") String authHeader, @RequestBody Item item)
    {
        String ticket=authHeader.substring(7);
        System.out.println(ticket);
        String username=jwtUtil.extractUsername(ticket);
//HttpHeaders.add(Authorization"")
        if (jwtUtil.validateToken(ticket,username)) {
            item.setUsername(username);
            itemServices.addItem(item);
            return "Item Added Successfully";
        }
        else
        {
            return "Unauthrized user ";
        }
    }
    @GetMapping("/getall")
    public List<Item> getAll(@RequestHeader("Authorization") String authHeader)
    {
        String ticket=authHeader.substring(7);
        String username=jwtUtil.extractUsername(ticket);
        if (jwtUtil.validateToken(ticket,username)) {
        return     itemServices.findAll();
        }
        else
        {
            return null;
        }

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getbydate")
        public List<Item> getBydate(@RequestHeader("Authorization") String authHeader, @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)
    {
        String ticket=authHeader.substring(7);
        String username=jwtUtil.extractUsername(ticket);
        if (jwtUtil.validateToken(ticket,username)) {
            return     itemServices.findBydate(startDate,endDate);
        }
        else
        {
            return null;
        }

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getprofit")
    public String getprofitbydate(@RequestHeader("Authorization") String authHeader, @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)throws Exception {
        {
            String ticket = authHeader.substring(7);
            String username = jwtUtil.extractUsername(ticket);
            if (jwtUtil.validateToken(ticket, username)) {
                if (itemServices.findProfitBetweenDates(startDate, endDate)!=null)
                {   return itemServices.findProfitBetweenDates(startDate, endDate);}
                else {
                    return "Zero";
                }
            }
            return "Not Uathorized User";
        }

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getprofitpermoth")
public List<MonthlyProfitDTO> getprofitpermonth(@RequestHeader("Authorization") String authHeader)
    {
        String ticket = authHeader.substring(7);
        String username = jwtUtil.extractUsername(ticket);
        if (jwtUtil.validateToken(ticket, username)) {
            return itemServices.ProfitPerMoth();
        }
        else
            return null;

    }



}
