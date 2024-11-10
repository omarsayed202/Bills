package com.Bills.Bills.Items;

import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServices {
    @Autowired
    ItemRepository itemRepository;


    public void addItem(Item item) {

        itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public List<Item> findBydate(LocalDate start, LocalDate end) {
       return itemRepository.findItemsBetweenDates(start,end);
    }
public String findProfitBetweenDates(LocalDate start, LocalDate end)
{
    return itemRepository.findProfitBetweenDates(start,end);
}

public List<MonthlyProfitDTO> ProfitPerMoth()
{
    List<Tuple> results =itemRepository.ProfitperMonth();
    return results.stream()
            .map(tuple -> new MonthlyProfitDTO(tuple.get("Month", Integer.class), BigDecimal.valueOf(tuple.get("profit", Double.class))))
            .collect(Collectors.toList());
}
}