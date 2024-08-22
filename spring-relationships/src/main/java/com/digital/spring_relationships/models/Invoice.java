package com.digital.spring_relationships.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invoices")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Invoice(String description, Double total) {
        this.description = description;
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
                " id=" + id + '\'' +
                ", description='" + description + '\'' +
                ", total=" + total + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Invoice invoice = (Invoice) obj;
        return id.equals(invoice.id);
    }
}
