package com.Bank.Userms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Username cannot be null")
    private String username;
    @NotNull(message = "Password cannot be null")
    private String password;
    @NotNull(message = "Address cannot be null")
    private String address;
    @NotNull(message = "Phone number cannot be null")
    private Long number;
    @NotNull(message = "Identity Proof cannot be null")
    private String identityProof;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role roles;

    private List<Long> accountids = new ArrayList<>();

    private List<Long> investmentids = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getIdentityProof() {
        return identityProof;
    }

    public void setIdentityProof(String identityProof) {
        this.identityProof = identityProof;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public List<Long> getAccountids() {
        return accountids;
    }

    public void setAccountids(List<Long> accountids) {
        this.accountids = accountids;
    }

    public List<Long> getInvestmentids() {
        return investmentids;
    }

    public void setInvestmentids(List<Long> investmentids) {
        this.investmentids = investmentids;
    }

    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(this.roles.getRoleName()));
//        return authorities;
//    }

//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
