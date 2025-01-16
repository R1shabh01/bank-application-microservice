package com.Bank.Adminms.service;

import com.Bank.Adminms.dto.AdminDto;
import com.Bank.Adminms.entity.Admin;
import com.Bank.Adminms.entity.Role;
import com.Bank.Adminms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public void registerAdmin(AdminDto adminDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(adminDto.getPassword());
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        Admin saveAdmin = new Admin();
        saveAdmin.setName(adminDto.getName());
        saveAdmin.setPassword(encodedPassword);
        saveAdmin.setUsername(adminDto.getUsername());
        saveAdmin.setIdentityProof(adminDto.getIdentityProof());
        saveAdmin.setNumber(adminDto.getNumber());
        saveAdmin.setRoles(role);
        saveAdmin.setAddress(adminDto.getAddress());
        adminRepository.save(saveAdmin);
    }


}
