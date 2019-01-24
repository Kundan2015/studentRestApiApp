package com.example.studentApp.repository;

import com.example.studentApp.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StdRepository extends JpaRepository<StudentModel, Long> {

}
