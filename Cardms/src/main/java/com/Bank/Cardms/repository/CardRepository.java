package com.Bank.Cardms.repository;


import com.Bank.Cardms.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

    Optional<Card> findByCardNumber(Long cardNumber);
}
