package br.com.henrique.curse.repositories;

import br.com.henrique.curse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
