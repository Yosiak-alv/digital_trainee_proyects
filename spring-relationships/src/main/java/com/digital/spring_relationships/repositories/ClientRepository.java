package com.digital.spring_relationships.repositories;

import com.digital.spring_relationships.models.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ClientRepository extends CrudRepository<Client,Long> {
    @Query("select c from Client c join fetch c.addresses where c.id = ?1")
    Optional<Client> findOneJoinWithAddresses(Long id);
}