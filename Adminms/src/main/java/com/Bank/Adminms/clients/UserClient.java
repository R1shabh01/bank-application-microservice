package com.Bank.Adminms.clients;

import com.Bank.Adminms.dto.AdminDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USERMS")
public interface UserClient {

    @PostMapping("/user/admin/register")
    String registerAdmin(@RequestBody AdminDto adminDto);

    @DeleteMapping("/{userId}")
    public String deleteUserById(@PathVariable Long userId);

}
