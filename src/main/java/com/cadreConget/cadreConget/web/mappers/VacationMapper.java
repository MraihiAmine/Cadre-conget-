package com.cadreConget.cadreConget.web.mappers;

import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.model.Vacation;
import com.cadreConget.cadreConget.model.Vacation;
import com.cadreConget.cadreConget.web.dto.VacationDto;
import com.cadreConget.cadreConget.web.dto.VacationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VacationMapper {
    @Mapping(target = "managerId", expression = "java(vacation.getManager().getManagerId())")
    VacationDto toVacationDto(Vacation vacation);
    List<VacationDto> toVacationDTOs(List<Vacation> vacations);
    @Mapping(target = "manager", source = "manager")
    Vacation toVacation(VacationDto vacationDto, Manager manager);
}
