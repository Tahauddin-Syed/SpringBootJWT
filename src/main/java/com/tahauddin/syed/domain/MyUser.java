package com.tahauddin.syed.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "My_Users")
public class MyUser {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String name;

    private String userName;

    private String password;

    @ManyToMany(fetch = EAGER)
    private List<MyRole> roles = new ArrayList();
}
