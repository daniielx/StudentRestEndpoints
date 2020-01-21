package com.example.rest01;

import org.springframework.data.repository.CrudRepository;



public interface StudentRepository extends CrudRepository<Student, StudentIdentity> {
}
