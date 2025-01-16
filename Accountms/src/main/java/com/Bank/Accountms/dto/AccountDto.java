package com.Bank.Accountms.dto;

import com.Bank.Accountms.entity.Nominee;
import lombok.Data;

@Data
public class AccountDto {

    private String accountType;

    private double balance;

    private String proof;

    private Nominee nominee;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public Nominee getNominee() {
        return nominee;
    }

    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
    }
}
