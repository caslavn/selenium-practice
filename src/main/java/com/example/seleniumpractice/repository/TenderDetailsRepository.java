package com.example.seleniumpractice.repository;

import com.example.seleniumpractice.dto.TenderDetailsDTO;
import com.example.seleniumpractice.model.TenderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenderDetailsRepository extends JpaRepository<TenderDetails, Integer> {

    @Query("SELECT td FROM TenderDetails td WHERE td.tender_id = :tender")
    List<TenderDetailsDTO> findOneById(@Param("tender") Integer tender);

}
