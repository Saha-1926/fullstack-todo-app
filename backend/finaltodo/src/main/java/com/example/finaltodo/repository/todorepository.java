package com.example.finaltodo.repository;

import com.example.finaltodo.entity.todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface todorepository extends JpaRepository<todo, Long> {

}