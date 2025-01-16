package com.Bank.ApiGateway.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {
   @NotNull(message = "Name cannot be null")
   private String name;
   @NotNull(message = "Username cannot be null")
   private String username;
   @NotNull(message = "Password cannot be null")
   private String password;
   @NotNull(message = "Address cannot be null")
   private String address;
   @NotNull(message = "Phone number cannot be null")
   private Long number;
   @NotNull(message = "Identity Proof cannot be null")
   private String identityProof;
   private List<Long> accountids = new ArrayList<>();
   private List<Long> investmentids = new ArrayList<>();

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public Long getNumber() {
      return number;
   }

   public void setNumber(Long number) {
      this.number = number;
   }

   public String getIdentityProof() {
      return identityProof;
   }

   public void setIdentityProof(String identityProof) {
      this.identityProof = identityProof;
   }

   public List<Long> getAccountids() {
      return accountids;
   }

   public void setAccountids(List<Long> accountids) {
      this.accountids = accountids;
   }

   public List<Long> getInvestmentids() {
      return investmentids;
   }

   public void setInvestmentids(List<Long> investmentids) {
      this.investmentids = investmentids;
   }
}
