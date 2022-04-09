package com.tahauddin.syed.repo;

import com.tahauddin.syed.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    MyUser findByName(String name);
}
