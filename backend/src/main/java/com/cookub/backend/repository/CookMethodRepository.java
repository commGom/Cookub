package com.cookub.backend.repository;

import com.cookub.backend.entity.CookMethod;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CookMethodRepository extends JpaRepository<CookMethod,Long> {
    
}
