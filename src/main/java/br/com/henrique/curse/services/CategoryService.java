package br.com.henrique.curse.services;

import br.com.henrique.curse.entities.Category;
import br.com.henrique.curse.entities.User;
import br.com.henrique.curse.repositories.CategoryRepository;
import br.com.henrique.curse.repositories.CategoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
