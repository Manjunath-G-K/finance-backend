package com.zorvyn.finance.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(unique = true, nullable = false)
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Role getRole ( ) {
        return role;
    }

    public void setRole ( Role role ) {
        this.role = role;
    }

    @Enumerated(EnumType.STRING)
    private Status status;



}