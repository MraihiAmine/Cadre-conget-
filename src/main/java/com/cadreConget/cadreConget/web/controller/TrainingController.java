package com.cadreConget.cadreConget.web.controller;

import com.cadreConget.cadreConget.model.Training;
import com.cadreConget.cadreConget.services.services.TrainingService;
import com.cadreConget.cadreConget.web.dto.TrainingDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/trainings")
public class TrainingController {
    private final TrainingService trainingService;

    @PostMapping
    public ResponseEntity<Void> createTraining(@RequestBody TrainingDto trainingDto){
        trainingService.save(trainingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/by-manager/{managerId}")
    public ResponseEntity<List<TrainingDto>>
            getAllTrainingsForManager(@PathVariable Long managerId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(trainingService.getAllTrainingsForManager(managerId));
    }
}
