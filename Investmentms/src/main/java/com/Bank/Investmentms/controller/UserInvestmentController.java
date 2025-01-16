package com.Bank.Investmentms.controller;


import com.Bank.Investmentms.dto.InvestmentDto;
import com.Bank.Investmentms.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invest")
public class UserInvestmentController {
    @Autowired
    InvestmentService investmentService;
    @PostMapping("/now")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('CUSTOMER')")
    public String investNow(@RequestParam Long accountId , @RequestBody InvestmentDto investmentDto)
    {
        return investmentService.investNow(accountId,investmentDto);
    }


}
