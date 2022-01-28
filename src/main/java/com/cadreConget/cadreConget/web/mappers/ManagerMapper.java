package com.cadreConget.cadreConget.web.mappers;

import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.web.dto.ManagerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ManagerMapper {
    ManagerDto toManagerDto(Manager manager);
    List<ManagerDto> toManagerDTOs(List<Manager> managers);
    Manager toManager(ManagerDto managerDto);
}
