package com.cadreConget.cadreConget.services.services;
import com.cadreConget.cadreConget.exception.ManagerNotFoundException;
import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.model.Training;
import com.cadreConget.cadreConget.model.Training;
import com.cadreConget.cadreConget.repository.ManagerRepository;
import com.cadreConget.cadreConget.repository.TrainingRepository;
import com.cadreConget.cadreConget.repository.TrainingRepository;
import com.cadreConget.cadreConget.web.dto.TrainingDto;
import com.cadreConget.cadreConget.web.mappers.TrainingMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@AllArgsConstructor
@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final ManagerRepository managerRepository;
    private final TrainingMapper trainingMapper;

    public Training save(TrainingDto trainingDto){
        Manager manager = managerRepository.findById(trainingDto.getManagerId())
                .orElseThrow(()-> new ManagerNotFoundException(
                        trainingDto.getManagerId().toString()));
        return trainingRepository.save(trainingMapper.toTraining(trainingDto, manager));
    }

    public List<TrainingDto> getAllTrainingsForManager(Long managerId){
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(()-> new ManagerNotFoundException(managerId.toString()));
        return trainingRepository.findAllByManager(manager)
                .stream()
                .map(trainingMapper::toTrainingDto)
                .collect(Collectors.toList());
    }
    public void deleteById(Long id){
        trainingRepository.deleteById(id);
    }
}
