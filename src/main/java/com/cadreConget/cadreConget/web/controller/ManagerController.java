package com.cadreConget.cadreConget.web.controller;

import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.services.services.ManagerService;
import com.cadreConget.cadreConget.web.dto.ManagerDto;
import com.cadreConget.cadreConget.web.mappers.ManagerMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.http.ResponseEntity.unprocessableEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/managers/")
@AllArgsConstructor
public class ManagerController {

    public final ManagerService managerService;
    private final ManagerMapper managerMapper;

    @PostMapping
    public ResponseEntity<ManagerDto> createManager(@RequestBody ManagerDto managerDto){
        Manager manager = managerMapper.toManager(managerDto);
        managerService.save(manager);
        return  ResponseEntity.status(HttpStatus.CREATED).body(managerDto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ManagerDto> getManager(@PathVariable Long id) {
        Optional<Manager> manager = managerService.findById(id);
        ManagerDto managerDto = managerMapper.toManagerDto(manager.get());
        return ResponseEntity.ok(managerDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ManagerDto>
    update(@PathVariable Long id, @RequestBody ManagerDto managerDto){
        Manager manager = managerMapper.toManager(managerDto);
        manager.setManagerId(id);

        managerService.save(manager);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(managerDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        managerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping
    public ResponseEntity<List<ManagerDto>> findAll(){
        List<ManagerDto> managerDtos
                = managerMapper.toManagerDTOs(managerService.findAll());
        return ResponseEntity.ok(managerDtos);
    }
}
