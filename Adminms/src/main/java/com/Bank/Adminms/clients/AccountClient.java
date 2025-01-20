package com.Bank.Adminms.clients;

import com.Bank.Adminms.dto.AccountType;
import com.Bank.Adminms.dto.BranchType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ACCOUNTMS")
public interface AccountClient {

    @DeleteMapping("/account/deactivate")
    public String deactivateAccountById(@RequestParam Long accountNumber, @RequestParam Long userId);

    @PostMapping("/account/activate")
    public String activateAccountById(@RequestParam Long accountNumber,@RequestParam Long userId);
    @PostMapping("/active")
    public List<Long> getAllActiveAccounts();
    @PostMapping("/inactive")
    public List<Long> getAllInactiveAccounts();
    @PostMapping("/by-account-type")
    public List<Long> getAccountsByAccountType(@RequestParam AccountType accountType) ;

    @PostMapping("/by-branch-type")
    public List<Long> getAccountsByBranchType(@RequestParam BranchType branchType);
}
