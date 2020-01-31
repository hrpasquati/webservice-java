package br.com.henrique.curse.repositories;

import br.com.henrique.curse.entities.OrderItem;
import br.com.henrique.curse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
