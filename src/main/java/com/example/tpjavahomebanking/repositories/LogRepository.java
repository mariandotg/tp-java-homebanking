package com.example.tpjavahomebanking.repositories;

import com.example.tpjavahomebanking.models.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log,Long>{
}
