package com.Bank.Adminms.service;

import com.Bank.Adminms.clients.AccountClient;
import com.Bank.Adminms.clients.UserClient;
import com.Bank.Adminms.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class AdminService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private AccountClient accountClient;

    public String registerAdmin(AdminDto adminDto) {
        return userClient.registerAdmin(adminDto);
    }

    public String deleteUser(Long userId) {
        return userClient.deleteUserById(userId);
    }

    public String deactivateUserAccount(Long userId, Long accountId) {
        return accountClient.deactivateAccountById(userId,accountId);
    }
    public String activateUserAccount(Long userId, Long accountId){
        return accountClient.activateAccountById(accountId,userId);
    }
}