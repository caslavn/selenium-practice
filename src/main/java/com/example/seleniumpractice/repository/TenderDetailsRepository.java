package com.example.seleniumpractice.repository;

import com.example.seleniumpractice.model.TenderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderDetailsRepository extends JpaRepository<TenderDetails, Integer> {
}
