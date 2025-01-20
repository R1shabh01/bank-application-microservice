package com.Bank.Accountms.repository;

import com.Bank.Accountms.entity.Account;
import com.Bank.Accountms.entity.AccountType;
import com.Bank.Accountms.entity.BranchType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByAccountNumber(Long accountNumber);
    @Query("SELECT a FROM Account a WHERE a.status = 'ACTIVE'")
    List<Account> findAllActiveAccounts();
    @Query("SELECT a from Account a WHERE a.userid = :id")
    List<Account> findByUserId(Long id);
    @Query("SELECT a FROM Account a WHERE a.status = 'INACTIVE'")
    List<Account> findAllInActiveAccounts();
    @Query("SELECT a FROM Account a WHERE a.accountType = :accountType")
    List<Account> findAllByAccountType(AccountType accountType);
    @Query("SELECT a FROM Account a WHERE a.branch = :branchType")
    List<Account> findAllByBranch(BranchType branchType);
    @Query("DELETE FROM Account a WHERE a.accountNumber = :accountNumber AND a.userid = :userId")
    void deleteAccountByUserId(Long accountNumber, Long userId);

    boolean existsByUserId(Long userId);

    Account findAccountByUserId(Long accountNumber,Long userid);
}
