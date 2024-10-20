package com.example.demo.Repository;

import com.example.demo.Entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Hello, Long> {
     Hello findHelloById(Long id);
}