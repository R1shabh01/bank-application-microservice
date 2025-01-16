package com.Bank.Accountms.repository;


import com.Bank.Accountms.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomineeRepository extends JpaRepository<Nominee,Long> {
}
