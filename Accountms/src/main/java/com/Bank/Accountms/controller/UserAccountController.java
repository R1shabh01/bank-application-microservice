package com.Bank.Accountms.controller;


import com.Bank.Accountms.dto.AccountDto;
import com.Bank.Accountms.dto.KycDto;
import com.Bank.Accountms.dto.NomineeDto;
import com.Bank.Accountms.entity.Account;
import com.Bank.Accountms.entity.AccountType;
import com.Bank.Accountms.entity.BranchType;
import com.Bank.Accountms.entity.Nominee;
import com.Bank.Accountms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class UserAccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/create/{userId}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public void accountOpening(@RequestBody AccountDto accountDto, @PathVariable Long userId)
    {
        accountService.createAccount(accountDto,userId);
    }

    @GetMapping("/all/{userId}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public List<Account> getAllAccountByUserId(@PathVariable Long userId)
    {
        return accountService.getAllAccountByUserId(userId);
    }

    @GetMapping("/balance")
    @PreAuthorize("hasRole('CUSTOMER')")
    public double getBalance(@RequestParam Long accountNumber)
    {
        return accountService.getBalanceAmount(accountNumber);
    }

    @GetMapping("/nominee")
    @PreAuthorize("hasRole('CUSTOMER')")
    public Nominee getNominee(@RequestParam Long accountNumber)
    {
        return accountService.getNominee(accountNumber);
    }

    @PutMapping("/updateNominee/{accountId}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public void updateNominee(@RequestBody NomineeDto nomineeDto, @PathVariable Long accountId )
    {
        accountService.updateNominee(nomineeDto,accountId);
    }

//    @GetMapping("/getKycDetails")
//    @PreAuthorize("hasRole('CUSTOMER')")
//    public User getKycDetails(@RequestParam Long accountNumber)
//    {
//        return accountService.getAccountKycDetail(accountNumber);
//    }

    @PutMapping("/updateKyc/{accountId}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public void updateKycDetails(@RequestBody KycDto kycDto, @PathVariable Long accountId)
    {
        accountService.updateKycDetails(kycDto,accountId);
    }

    @GetMapping("/getAccount/summary")
    @PreAuthorize("hasRole('CUSTOMER')")
    public Account getAccountSummary(@RequestParam Long accountNumber)
    {
        return accountService.getAccountDetail(accountNumber);
    }

    @DeleteMapping("/deactivate")
    @PreAuthorize("hasRole('ADMIN')")
    public String deactivateAccountById(@RequestParam Long accountNumber,@RequestParam Long userId)
    {
       return accountService.deleteAccountByUserId(accountNumber , userId);
    }

    @PostMapping("/activate")
    @PreAuthorize("hasRole('ADMIN')")
    public String activateAccountById(@RequestParam Long accountNumber,@RequestParam Long userId){
        return accountService.activateAccountById(accountNumber,userId);
    }
    @PostMapping("/active")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Account> getAllActiveAccounts() {
         return accountService.getAllActiveAccountList();
    }
    @PostMapping("/inactive")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Account> getAllInactiveAccounts() {
        return accountService.getAllInActiveAccountList();
    }
    @PostMapping("/by-account-type")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Account> getAccountsByAccountType(@RequestParam AccountType accountType) {
        return accountService.byAccType(accountType);
    }
    @PostMapping("/by-branch-type")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Account> getAccountsByBranchType(@RequestParam BranchType branchType) {
        return accountService.byBranchType(branchType);
    }
}
