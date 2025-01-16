package com.Bank.Accountms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Account {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Enumerated(EnumType.STRING)
   private AccountType accountType;

   private String status;

   private double balance;

   private float interestRate;

   @Enumerated(EnumType.STRING)
   private BranchType branch;

   private String proof;

   private Date openingDate;

   private Long accountNumber;

   @OneToOne(cascade = CascadeType.ALL)
   private Nominee nominee;

   private Long cardid;

   private Long userid;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public AccountType getAccountType() {
      return accountType;
   }

   public void setAccountType(AccountType accountType) {
      this.accountType = accountType;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public double getBalance() {
      return balance;
   }

   public void setBalance(double balance) {
      this.balance = balance;
   }

   public float getInterestRate() {
      return interestRate;
   }

   public void setInterestRate(float interestRate) {
      this.interestRate = interestRate;
   }

   public BranchType getBranch() {
      return branch;
   }

   public void setBranch(BranchType branch) {
      this.branch = branch;
   }

   public String getProof() {
      return proof;
   }

   public void setProof(String proof) {
      this.proof = proof;
   }

   public Date getOpeningDate() {
      return openingDate;
   }

   public void setOpeningDate(Date openingDate) {
      this.openingDate = openingDate;
   }

   public Long getAccountNumber() {
      return accountNumber;
   }

   public void setAccountNumber(Long accountNumber) {
      this.accountNumber = accountNumber;
   }

   public Nominee getNominee() {
      return nominee;
   }

   public void setNominee(Nominee nominee) {
      this.nominee = nominee;
   }

   public Long getCardid() {
      return cardid;
   }

   public void setCardid(Long cardid) {
      this.cardid = cardid;
   }

   public Long getUserid() {
      return userid;
   }

   public void setUserid(Long userid) {
      this.userid = userid;
   }
}
