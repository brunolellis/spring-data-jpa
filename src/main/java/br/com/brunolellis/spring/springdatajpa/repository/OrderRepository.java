package br.com.brunolellis.spring.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brunolellis.spring.springdatajpa.domain.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByCustomerContaining(String customer);

	List<Order> findDistinctByItemsPriceGreaterThan(double price);
	
}
