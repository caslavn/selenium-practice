package com.example.seleniumpractice.repository;

import com.example.seleniumpractice.model.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderRepository extends JpaRepository<Tender, Integer> {
}
