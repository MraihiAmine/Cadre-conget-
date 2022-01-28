package com.cadreConget.cadreConget.web.controller;

import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.model.Training;
import com.cadreConget.cadreConget.services.services.TrainingService;
import com.cadreConget.cadreConget.web.dto.TrainingDto;
import com.cadreConget.cadreConget.web.mappers.TrainingMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/trainings")
public class TrainingController {
    public final TrainingService trainingService;
    public final TrainingMapper trainingMapper;

    @PostMapping
    public ResponseEntity<TrainingDto>
    createTraining(@RequestBody TrainingDto trainingDto){
            trainingService.save(trainingDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(trainingDto);
    }
    @GetMapping("/by-manager/{managerId}")
    public ResponseEntity<List<TrainingDto>> getAllCommentsForPost(@PathVariable Long managerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(trainingService.getAllTrainingsForManager(managerId));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        trainingService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
