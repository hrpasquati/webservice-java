package br.com.henrique.curse.repositories;

import br.com.henrique.curse.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
