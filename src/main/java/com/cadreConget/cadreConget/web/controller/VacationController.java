package com.cadreConget.cadreConget.web.controller;

import com.cadreConget.cadreConget.services.services.VacationService;
import com.cadreConget.cadreConget.services.services.VacationService;
import com.cadreConget.cadreConget.web.dto.VacationDto;
import com.cadreConget.cadreConget.web.dto.VacationDto;
import com.cadreConget.cadreConget.web.mappers.VacationMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vacations")
public class VacationController {
    public final VacationService vacationService;
    public final VacationMapper vacationMapper;

    @PostMapping
    public ResponseEntity<VacationDto>
    createVacation(@RequestBody VacationDto vacationDto){
        vacationService.save(vacationDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(vacationDto);
    }
    @GetMapping("/by-manager/{managerId}")
    public ResponseEntity<List<VacationDto>> getAllCommentsForPost(@PathVariable Long managerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vacationService.getAllVacationsForManager(managerId));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        vacationService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
