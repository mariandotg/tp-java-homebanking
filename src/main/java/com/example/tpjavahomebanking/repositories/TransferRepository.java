package com.example.tpjavahomebanking.repositories;



import com.example.tpjavahomebanking.models.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
