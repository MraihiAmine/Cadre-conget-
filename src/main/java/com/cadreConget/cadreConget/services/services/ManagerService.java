package com.cadreConget.cadreConget.services.services;

import com.cadreConget.cadreConget.exception.ManagerNotFoundException;
import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.PrivateKey;
import java.util.List;

@AllArgsConstructor
@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public void save(Manager manager){
            managerRepository.save(manager);
    }
    @Transactional(readOnly = true)
    public Manager getManager(Long id){
        Manager manager = managerRepository.findById(id)
                .orElseThrow(()-> new ManagerNotFoundException(id.toString()));
        return manager;
    }
    @Transactional(readOnly = true)
    public List<Manager> getAllManagers(){
        return managerRepository.findAll();
    }
}
