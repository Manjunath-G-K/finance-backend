package com.zorvyn.finance.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Type getType ( ) {
        return type;
    }

    public void setType ( Type type ) {
        this.type = type;
    }

    public Double getAmount ( ) {
        return amount;
    }

    public void setAmount ( Double amount ) {
        this.amount = amount;
    }

    public User getUser ( ) {
        return user;
    }

    @NotNull(message = "Amount is required")
    private Double amount;

    @NotNull(message = "Type is required")
    private Type type;

    private String category;

    private LocalDate date;

    private String note;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}