package com.Bills.Bills.Items;

import com.Bills.Bills.Auth.User;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.date BETWEEN ?1 AND ?2")
    List<Item> findItemsBetweenDates(LocalDate startDate, LocalDate endDate);
    @Query("SELECT sum(i.profit) FROM Item i WHERE i.date BETWEEN ?1 AND ?2")
    String findProfitBetweenDates(LocalDate startDate, LocalDate endDate);


    @Query("SELECT  DISTINCT(Month(i.date)) as Month,sum(i.profit) as profit from Item i where  i.date IS NOT NULL  group by month(i.date)")
    List<Tuple>ProfitperMonth();
    Optional<Item> findById(Long id);
}
