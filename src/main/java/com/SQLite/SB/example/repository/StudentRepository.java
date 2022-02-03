package com.SQLite.SB.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SQLite.SB.example.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public boolean existsByEmail(String email);

    public List<Student> findByEmail(String email);

    public List<Student> findByName(String name);

    @Query(value = "select  s.id, s.name, s.email from Student s WHERE s.name like  %:name%", nativeQuery = true)
    public List<Student> listarEstudiantePorLetra(@Param("name") String name);

    @Query("select max(s.id) from Student s")
    public Integer findMaxId();
}
