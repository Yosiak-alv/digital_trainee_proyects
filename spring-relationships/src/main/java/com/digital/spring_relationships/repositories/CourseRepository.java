package com.digital.spring_relationships.repositories;

import com.digital.spring_relationships.models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {
    @Query("select c from Course c left join fetch c.students where c.id = ?1")
    Optional<Course> findOneWithStudents(Long id);
}
