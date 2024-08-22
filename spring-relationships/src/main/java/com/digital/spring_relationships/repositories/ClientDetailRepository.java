package com.digital.spring_relationships.repositories;

import com.digital.spring_relationships.models.ClientDetails;
import org.springframework.data.repository.CrudRepository;

public interface ClientDetailRepository  extends CrudRepository<ClientDetails, Long> {
}
