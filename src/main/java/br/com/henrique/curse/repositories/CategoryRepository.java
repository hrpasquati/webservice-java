package br.com.henrique.curse.repositories;

import br.com.henrique.curse.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
