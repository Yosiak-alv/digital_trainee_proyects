package com.digital.spring_relationships.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double total;

    @ManyToOne
    private Client client;

    public Invoice(String description, Double total) {
        this.description = description;
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id + '\'' +
                ", description='" + description + '\'' +
                ", total=" + total + '\'' +
                ", client=" + client +
                '}';
    }
}
