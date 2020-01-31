package br.com.henrique.curse.repositories;

import br.com.henrique.curse.entities.Category;
import br.com.henrique.curse.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
