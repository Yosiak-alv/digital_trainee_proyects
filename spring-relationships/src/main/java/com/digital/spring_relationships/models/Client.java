package com.digital.spring_relationships.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clients")
@Setter
@Getter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;

    //@JoinColumn(name = "client_id")
    //this type of relation is One reference to client and many references to addresses
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "clients_addresses",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"address_id"})
    )
    private Set<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private Set<Invoice> invoices;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private ClientDetails clientDetails;

    public Client() {
        this.addresses = new HashSet<>();
        this.invoices = new HashSet<>();
    }

    public Client(String name, String lastname) {
        this();
        this.name = name;
        this.lastname = lastname;
    }

    public Client addInvoice(Invoice invoice){
        this.invoices.add(invoice);
        invoice.setClient(this);
        return this;
    }
    public void removeInvoice(Invoice invoice){
        this.getInvoices().removeIf(invoice1 -> invoice1.getId().equals(invoice.getId()));
        invoice.setClient(null);
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
        clientDetails.setClient(this);
    }

    public void removeClientDetails(ClientDetails clientDetails){
        this.clientDetails = null;
        clientDetails.setClient(null);
        /* if(this.clientDetails != null){
            this.clientDetails.setClient(null);
            this.clientDetails = null;
        }*/
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", addresses=" + addresses + '\'' +
                ", invoices=" + invoices +
                '}';
    }

}
