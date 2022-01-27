package com.cadreConget.cadreConget.services.services;
import com.cadreConget.cadreConget.exception.ManagerNotFoundException;
import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.model.Training;
import com.cadreConget.cadreConget.repository.ManagerRepository;
import com.cadreConget.cadreConget.repository.TrainingRepository;
import com.cadreConget.cadreConget.web.dto.TrainingDto;
import com.cadreConget.cadreConget.web.mappers.TrainingMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TrainingService {
   private final ManagerRepository managerRepository;
   private final TrainingRepository trainingRepository;
   private final TrainingMapper trainingMapper;

   public void save(TrainingDto trainingDto){
      Manager manager = managerRepository.findById(trainingDto.getManagerId())
              .orElseThrow(()->new ManagerNotFoundException(
                      trainingDto.getManagerId().toString()));
      trainingRepository.save(trainingMapper.map(trainingDto,manager));
   }

   public List<TrainingDto> getAllTrainingsForManager(Long managerId){
      Manager manager = managerRepository.findById(managerId)
              .orElseThrow(()->new ManagerNotFoundException(managerId.toString()));
      return trainingRepository.findAllByManager(manager)
              .stream()
              .map(trainingMapper::mapToDto)
              .collect(Collectors.toList());
   }
}
