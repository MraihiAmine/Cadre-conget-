package com.cadreConget.cadreConget.repository;

import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.model.Training;
import com.cadreConget.cadreConget.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {
   List<Vacation> findAllByManager(Manager manager);
}
