package com.cadreConget.cadreConget.web.mappers;

import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.model.Training;
import com.cadreConget.cadreConget.web.dto.TrainingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrainingMapper {
   @Mapping(target = "managerId", expression = "java(training.getManager().getManagerId())")
   TrainingDto toTrainingDto(Training training);
   List<TrainingDto> toTrainingDTOs(List<Training> trainings);
   @Mapping(target = "manager", source = "manager")
   Training toTraining(TrainingDto trainingDto, Manager manager);
}
