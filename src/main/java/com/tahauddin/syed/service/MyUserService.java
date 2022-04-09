package com.tahauddin.syed.service;

import com.tahauddin.syed.domain.MyRole;
import com.tahauddin.syed.domain.MyUser;

import java.util.List;

public interface MyUserService {

    MyUser saveMyUser(MyUser myUser);
    MyRole saveMyRole(MyRole myRole);
    void addRoleToUser(String username, String roleName);
    MyUser getMyUser(String username);
    List<MyUser> getAllUsers();
}
