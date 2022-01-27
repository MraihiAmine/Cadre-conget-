package com.cadreConget.cadreConget.web.mappers;

import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.model.Training;
import com.cadreConget.cadreConget.model.Vacation;
import com.cadreConget.cadreConget.web.dto.TrainingDto;
import com.cadreConget.cadreConget.web.dto.VacationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VacationMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "startDate", source = "vacationDto.startDate")
    @Mapping(target = "endDate", source = "vacationDto.endDate")
    @Mapping(target = "manager", source = "manager")
    Vacation map(VacationDto vacationDto, Manager manager);

    @Mapping(target = "managerId", expression = "java(vacation.getManager().getManagerId())")
    VacationDto mapToDto(Vacation vacation);
}
