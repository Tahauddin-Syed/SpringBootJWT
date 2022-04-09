package com.tahauddin.syed.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "My_Roles")
public class MyRole {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String roleName;

}
