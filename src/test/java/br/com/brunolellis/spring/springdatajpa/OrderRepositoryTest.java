package br.com.brunolellis.spring.springdatajpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.brunolellis.spring.springdatajpa.domain.Item;
import br.com.brunolellis.spring.springdatajpa.domain.Order;
import br.com.brunolellis.spring.springdatajpa.repository.OrderRepository;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = false)
public class OrderRepositoryTest {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void create() {
		Order order = new Order();
		order.setCustomer("xulapa " + new Date());
		
		Item item1 = new Item(order, "PlayStation 3", 900.00, 1);
		order.getItems().add(item1);
		
		Item item2 = new Item(order, "XBOX 360", 600.00, 1);
		order.getItems().add(item2);
		
		Order newOrder = orderRepository.save(order);
		assertNotNull(newOrder);
		
	}
	
	@Test
	public void updateOrder() {
		Order order = orderRepository.findOne(1L);
		
		String newCustomer = "xulapa " + new Date();
		order.setCustomer(newCustomer);
		
		orderRepository.save(order);
		
		Order newOrder = orderRepository.findOne(1L);
		
		assertEquals(newOrder.getCustomer(), newCustomer);
		
	}
	
	@Test
	public void addNewItem() {
		Order order = orderRepository.findOne(1L);
		Item item = new Item(order, "Atari", 1000.00, 1);
		order.getItems().add(item);
		
		orderRepository.save(order);
		
	}
	
	@Test
	public void findByCustomerContaining() {
		List<Order> orders = orderRepository.findByCustomerContaining("xulapa");
		printOrders(orders);
		
	}
	
	@Test
	public void findItems() {
		List<Order> orders = orderRepository.findDistinctByItemsPriceGreaterThan(100.00);
		printOrders(orders);
		
	}

	private void printOrders(Collection<Order> orders) {
		for (Order order : orders) {
			System.out.println(order);
			
		}
		
	}

}
