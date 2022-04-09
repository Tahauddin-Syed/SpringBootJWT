package com.tahauddin.syed.repo;

import com.tahauddin.syed.domain.MyRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRoleRepository extends JpaRepository<MyRole, Long> {

    MyRole findByRoleName(String name);

}
