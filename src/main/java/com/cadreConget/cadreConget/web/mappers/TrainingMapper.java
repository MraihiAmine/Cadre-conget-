package com.cadreConget.cadreConget.web.mappers;

import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.model.Training;
import com.cadreConget.cadreConget.web.dto.TrainingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TrainingMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "startDate", source = "trainingDto.startDate")
    @Mapping(target = "endDate", source = "trainingDto.endDate")
    @Mapping(target = "manager", source = "manager")
    Training map(TrainingDto trainingDto, Manager manager);

    @Mapping(target = "managerId", expression = "java(training.getManager().getManagerId())")
    TrainingDto mapToDto(Training training);
}
