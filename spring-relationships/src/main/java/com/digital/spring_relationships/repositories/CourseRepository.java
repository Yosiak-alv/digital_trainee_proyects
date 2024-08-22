package com.digital.spring_relationships.repositories;

import com.digital.spring_relationships.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
