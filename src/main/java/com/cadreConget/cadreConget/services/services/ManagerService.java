package com.cadreConget.cadreConget.services.services;

import com.cadreConget.cadreConget.exception.ManagerNotFoundException;
import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@AllArgsConstructor
@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    public List<Manager> findAll(){
        return managerRepository.findAll();
    }

    public Optional<Manager> findById(Long id){
        return managerRepository.findById(id);
    }

    public Manager save(Manager manager){
            return managerRepository.save(manager);
    }

    public void deleteById(Long id){
        managerRepository.deleteById(id);
    }

}
