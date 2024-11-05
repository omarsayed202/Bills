package com.Bills.Bills;

import com.Bills.Bills.Items.Item;
import com.Bills.Bills.Items.ItemRepository;
import com.Bills.Bills.Items.ItemServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BillsApplicationTests {

	@Mock
	private ItemRepository itemRepository;

	@InjectMocks
	private ItemServices itemServices;

	@Test
	void testCalculateProfitBetweenDates() {
		// Arrange
		LocalDate startDate = LocalDate.of(2024, 10, 1);
		LocalDate endDate = LocalDate.of(2024, 11, 3);
		String mockProfit = "11376";

		// Mocking repository response
		when(itemRepository.findProfitBetweenDates(startDate, endDate)).thenReturn(String.valueOf(mockProfit));

		// Act
		String calculatedProfit = itemServices.findProfitBetweenDates(startDate, endDate);
			System.out.println(calculatedProfit);
		// Assert
		assertEquals(mockProfit, calculatedProfit);
	}

	@Test
	void testgetItemById() {
		// Arrange
		long id=4L;
		Optional<Item> expected= Optional.of(new Item(4L,null,99,100,0,0,8900,LocalDate.of(2024, 9, 29),"omar"));
		// Mocking repository response
		System.out.println(expected.get());
		when(itemRepository.findById(id)).thenReturn(expected);
		// Act
		Optional<Item> getItem =itemServices.getbyid(4L);
		System.out.println(getItem.get());
		// Assert
		assertEquals(expected, getItem);
	}
	@Test
	void testgetItemById2() {
		// Arrange
		long id=5L;
		Optional<Item> expected= Optional.of(new Item(5L,null,99,100,0,0,8900,LocalDate.of(2024, 9, 29),"omar"));
		// Mocking repository response
		System.out.println(expected.get());
		when(itemRepository.findById(id)).thenReturn(expected);
		// Act
		Optional<Item> getItem =itemServices.getbyid(5L);
		System.out.println(getItem.get());
		// Assert
		assertEquals(expected, getItem);
	}
}
