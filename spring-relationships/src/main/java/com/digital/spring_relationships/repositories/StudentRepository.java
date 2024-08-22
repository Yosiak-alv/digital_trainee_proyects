package com.digital.spring_relationships.repositories;

import com.digital.spring_relationships.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
