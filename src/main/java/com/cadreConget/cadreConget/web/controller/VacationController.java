package com.cadreConget.cadreConget.web.controller;

import com.cadreConget.cadreConget.services.services.VacationService;
import com.cadreConget.cadreConget.web.dto.VacationDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vacations")
public class VacationController {
    private final VacationService vacationService;

    @PostMapping
    public ResponseEntity<Void>
    createVacation(@RequestBody VacationDto vacationDto){
        vacationService.save(vacationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/by-manager/{managerId}")
    public ResponseEntity<List<VacationDto>>
    getAllVacationsByManager(@PathVariable Long managerId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vacationService.getAllVacationsForManager(managerId));
    }
}
