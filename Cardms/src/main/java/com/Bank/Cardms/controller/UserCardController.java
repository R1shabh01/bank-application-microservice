package com.Bank.Cardms.controller;


import com.Bank.Cardms.dto.CardDto;
import com.Bank.Cardms.entity.Card;
import com.Bank.Cardms.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class UserCardController {

    @Autowired
    CardService cardService;

    @GetMapping("/block")
    @PreAuthorize("hasRole('CUSTOMER')")
    public String blockCard(@RequestParam Long accountNumber,@RequestParam Long cardNumber)
    {
        return cardService.blockCard(accountNumber,cardNumber);
    }

    @PostMapping("/apply/new")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('CUSTOMER')")
    public String applyNewCard(@RequestParam Long accountNumber, @RequestBody CardDto cardDto)
    {
        return cardService.applyNewCard(accountNumber,cardDto);
    }

    @PutMapping("/setting")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('CUSTOMER')")
    public void modifyLimit(@RequestBody Card card, @RequestParam Long cardNumber)
    {
        cardService.modifySetting(cardNumber,card);
    }

}


