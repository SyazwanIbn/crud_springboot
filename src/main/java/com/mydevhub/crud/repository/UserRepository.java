package com.mydevhub.crud.repository;

import com.mydevhub.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    // JpaRepository<Entity, TypeOfPrimaryKey>
    // Spring akan auto provide method seperti save(), findById(), findAll(), deleteById()
    // Kalau nak custom query, boleh tambah sini. Contoh:
    // Optional<User> findByUsername(String username);
}
