package com.digital.spring_relationships.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client_details")
@Getter
@Setter
public class ClientDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean premium;
    private Integer points;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public ClientDetails() {}
    public ClientDetails(boolean premium, Integer points) {
        this.premium = premium;
        this.points = points;
    }

    @Override
    public String toString() {
        return "{" +
                    "id=" + id + '\'' +
                ", premium='" + premium + '\'' +
                ", points='" + points +
                '}';
    }

}
