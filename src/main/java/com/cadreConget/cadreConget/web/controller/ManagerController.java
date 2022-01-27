package com.cadreConget.cadreConget.web.controller;

import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.services.services.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.status;
import java.util.List;

@RestController
@RequestMapping("/api/managers/")
@AllArgsConstructor
public class ManagerController {
    public final ManagerService managerService;

    @PostMapping
    public ResponseEntity<Void> createManager(@RequestBody Manager manager){
        managerService.save(manager);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Manager>> getAllManagers(){
        return status(HttpStatus.OK).body(managerService.getAllManagers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManager(@PathVariable Long id) {
        return status(HttpStatus.OK).body(managerService.getManager(id));
    }

}
