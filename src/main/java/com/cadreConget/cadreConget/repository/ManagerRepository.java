package com.cadreConget.cadreConget.repository;

import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Optional<Manager> findByEmail(String email);
}
