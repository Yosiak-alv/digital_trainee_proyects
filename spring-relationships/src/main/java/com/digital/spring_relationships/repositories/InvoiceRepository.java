package com.digital.spring_relationships.repositories;

import com.digital.spring_relationships.models.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface InvoiceRepository extends CrudRepository<Invoice,Long> {
}
