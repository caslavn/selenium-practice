package com.example.seleniumpractice.repository;

import com.example.seleniumpractice.model.TenderQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenderQueueRepository extends JpaRepository<TenderQueue, Integer> {

    @Query(value = "SELECT * FROM tender_queue tq WHERE status = 'PENDING' ORDER BY created_at ASC", nativeQuery = true)
    List<TenderQueue> getQueue();

    @Query(value = "UPDATE tender_queue tq SET status = :status WHERE status='PENDING' AND tq.tender_id = :tender", nativeQuery = true)
    void updateStatus(@Param("tender") Integer tender, @Param("status") String status);

}