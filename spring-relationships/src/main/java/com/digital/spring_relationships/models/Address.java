package com.digital.spring_relationships.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String number;


    public Address() {
    }

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number +
                '}';
    }
}
