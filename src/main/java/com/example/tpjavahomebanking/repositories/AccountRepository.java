package com.example.tpjavahomebanking.repositories;

import com.example.tpjavahomebanking.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
}
