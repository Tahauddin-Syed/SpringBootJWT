package com.tahauddin.syed.service.impl;

import com.tahauddin.syed.domain.MyRole;
import com.tahauddin.syed.domain.MyUser;
import com.tahauddin.syed.repo.MyRoleRepository;
import com.tahauddin.syed.repo.MyUserRepository;
import com.tahauddin.syed.service.MyUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MyUserServiceImpl implements MyUserService, UserDetailsService {


    private final MyUserRepository myUserRepository;
    private final MyRoleRepository myRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser myUser = myUserRepository.findByName(username);
        if(null == myUser){
            log.error("User Not Found :: {}", username);
            throw new UsernameNotFoundException("User Not Found with the given Name :: " + username);
        }else{
            log.info("User Found in DB :: {}", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        myUser.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return new User(myUser.getUserName(), myUser.getPassword(), authorities);
    }

    @Override
    public MyUser saveMyUser(MyUser myUser) {
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        MyUser savedMyUser = myUserRepository.save(myUser);
        log.info("Saving My User To DB :: {}", myUser.getName());
        return savedMyUser;
    }

    @Override
    public MyRole saveMyRole(MyRole myRole) {
        log.info("Saving My Role To DB :: {}", myRole.getRoleName());
        return myRoleRepository.save(myRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        MyUser myUser = myUserRepository.findByName(username);
        MyRole myRole = myRoleRepository.findByRoleName(roleName);
        myUser.getRoles().add(myRole);
    }

    @Override
    public MyUser getMyUser(String username) {
        log.info("Getting My User From DB :: {}", username);
        return myUserRepository.findByName(username);
    }

    @Override
    public List<MyUser> getAllUsers() {
        log.info("Getting all Users From DB");
        return myUserRepository.findAll();
    }
}
