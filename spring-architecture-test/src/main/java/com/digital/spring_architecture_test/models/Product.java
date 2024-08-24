package com.digital.spring_architecture_test.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString(exclude = "orders")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name = "unit_price")
    private Double unitPrice;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if(id == null){
            if(other.id != null)
                return false;
        } else if(!id.equals(other.id))
            return false;
        if(name == null){
            if(other.name != null)
                return false;
        } else if(!name.equals(other.name))
            return false;
        if(description == null){
            if(other.description != null)
                return false;
        } else if(!description.equals(other.description))
            return false;
        if(unitPrice == null){
            if(other.unitPrice != null)
                return false;
        } else if(!unitPrice.equals(other.unitPrice))
            return false;
        return true;
    }
}
