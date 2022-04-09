package com.tahauddin.syed.bootstrap;

import com.tahauddin.syed.domain.MyRole;
import com.tahauddin.syed.domain.MyUser;
import com.tahauddin.syed.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class LoadData implements CommandLineRunner {

    private final MyUserService myUserService;

    @Override
    public void run(String... args) throws Exception {
        saveMyUsers();
    }

    private void saveMyUsers() {

        MyRole user = new MyRole();
        user.setRoleName("ROLE_USER");

        MyRole manager = new MyRole();
        manager.setRoleName("ROLE_MANAGER");

        MyRole admin = new MyRole();
        admin.setRoleName("ROLE_ADMIN");

        MyRole superAdmin = new MyRole();
        superAdmin.setRoleName("ROLE_SUPER_ADMIN");

        myUserService.saveMyRole(admin);
        myUserService.saveMyRole(user);
        myUserService.saveMyRole(manager);
        myUserService.saveMyRole(superAdmin);

        MyUser luisLitt = new MyUser();
        luisLitt.setName("Luis");
        luisLitt.setPassword("123456");
        luisLitt.setUserName("Luis Litt");
        luisLitt.setRoles(new ArrayList<>());

        MyUser harveySpector = new MyUser();
        harveySpector.setName("harvey");
        harveySpector.setPassword("123456");
        harveySpector.setUserName("Harvey Spector");
        harveySpector.setRoles(new ArrayList<>());

        MyUser jessica = new MyUser();
        jessica.setName("jessica");
        jessica.setPassword("123456");
        jessica.setUserName("Jessica");
        jessica.setRoles(new ArrayList<>());

        MyUser mikeRoss = new MyUser();
        mikeRoss.setName("mike");
        mikeRoss.setPassword("123456");
        mikeRoss.setUserName("Mike Ross");
        mikeRoss.setRoles(new ArrayList<>());

        myUserService.saveMyUser(luisLitt);
        myUserService.saveMyUser(harveySpector);
        myUserService.saveMyUser(jessica);
        myUserService.saveMyUser(mikeRoss);

        myUserService.addRoleToUser(luisLitt.getName(), manager.getRoleName());
        myUserService.addRoleToUser(mikeRoss.getName(), user.getRoleName());
        myUserService.addRoleToUser(harveySpector.getName(), manager.getRoleName());
        myUserService.addRoleToUser(jessica.getName(), superAdmin.getRoleName());

    }
}
