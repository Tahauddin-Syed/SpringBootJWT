package com.tahauddin.syed.controller;

import com.tahauddin.syed.domain.MyRole;
import com.tahauddin.syed.domain.MyUser;
import com.tahauddin.syed.dto.RoleToUser;
import com.tahauddin.syed.service.MyUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/myUser")
public class MyUserController {

    private final MyUserService myUserService;


    @GetMapping("/getAll")
    public ResponseEntity<List<MyUser>> getAllUsers(){
        return ResponseEntity.ok(myUserService.getAllUsers());
    }


    @PostMapping("/save/user")
    public ResponseEntity<MyUser> saveUser(@RequestBody MyUser myUser){

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/v1/myUser/save/user").toUriString());

        return ResponseEntity.created(uri).body(myUserService.saveMyUser(myUser));
    }

    @PostMapping("/save/role")
    public ResponseEntity<MyRole> saveRole(@RequestBody MyRole myRole){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/v1/myUser/save/role").toUriString());
        return ResponseEntity.created(uri).body(myUserService.saveMyRole(myRole));
    }

    @PostMapping("/add/role/to/user")
    public ResponseEntity<MyRole> addRoleToUser(@RequestBody RoleToUser roleToUser){
        myUserService.addRoleToUser(roleToUser.getUsername(), roleToUser.getRolename());
        return ResponseEntity
                .ok()
                .build();
    }
}
