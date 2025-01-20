package com.Bank.Userms.service;

import com.Bank.Userms.dto.UserDto;
import com.Bank.Userms.entity.Role;
import com.Bank.Userms.entity.User;
import com.Bank.Userms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public void registerUser(UserDto userDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userDto.getPassword());
        Role role = new Role();
        role.setRoleName("ROLE_CUSTOMER");
        User saveUser = new User();
        saveUser.setName(userDto.getName());
        saveUser.setPassword(encodedPassword);
        saveUser.setUsername(userDto.getUsername());
        saveUser.setIdentityProof(userDto.getIdentityProof());
        saveUser.setNumber(userDto.getNumber());
        saveUser.setRoles(role);
        saveUser.setAddress(userDto.getAddress());
        userRepository.save(saveUser);
    }

    public void registerAdmin(UserDto adminDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(adminDto.getPassword());
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        User saveAdmin = new User();
        saveAdmin.setName(adminDto.getName());
        saveAdmin.setPassword(encodedPassword);
        saveAdmin.setUsername(adminDto.getUsername());
        saveAdmin.setIdentityProof(adminDto.getIdentityProof());
        saveAdmin.setNumber(adminDto.getNumber());
        saveAdmin.setRoles(role);
        saveAdmin.setAddress(adminDto.getAddress());
        userRepository.save(saveAdmin);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByName(String username) {
        return userRepository.findByUsername(username).get();
    }

    public String deleteUserById(Long userId) {
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
            return "Deleted Successfully";
        }
         return "Error in deletion";
    }

//    public String deactivateUser(Long userId,Long accountId) {
//        if(userRepository.existsById(userId) && accountRepository.existsById(accountId)){
//            User user = userRepository.findById(userId).get();
//            Account account = accountRepository.findById(accountId).get();
//            if(user.getAccountList().contains(account)){
//                System.out.println("Account Found");
//                account.setStatus("INACTIVE");
//                accountRepository.save(account);
//            }
//            return "Deactivated Account for User with id: "+userId;
//        }
//        return "ERROR";
//    }

//    public String activateAccount(Long userId, Long accountId) {
//        if(userRepository.existsById(userId) && accountRepository.existsById(accountId)){
//            User user = userRepository.findById(userId).get();
//            Account account = accountRepository.findById(accountId).get();
//            if(user.getAccountList().contains(account) && account.getStatus().equals("INACTIVE")){
//                System.out.println("1 Account Found");
//                account.setStatus("ACTIVE");
//                accountRepository.save(account);
//                return "Activated Account for User with id: "+userId;
//            }
//        }
//        return "ERROR";
//    }

}
