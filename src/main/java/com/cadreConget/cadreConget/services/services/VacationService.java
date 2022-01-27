package com.cadreConget.cadreConget.services.services;

import com.cadreConget.cadreConget.exception.ManagerNotFoundException;
import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.repository.ManagerRepository;
import com.cadreConget.cadreConget.repository.VacationRepository;
import com.cadreConget.cadreConget.web.dto.TrainingDto;
import com.cadreConget.cadreConget.web.dto.VacationDto;
import com.cadreConget.cadreConget.web.mappers.VacationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class VacationService {
    private final ManagerRepository managerRepository;
    private final VacationRepository vacationRepository;
    private final VacationMapper vacationMapper;

    public void save(VacationDto vacationDto){
        Manager manager = managerRepository.findById(vacationDto.getManagerId())
                .orElseThrow(()->new ManagerNotFoundException(
                        vacationDto.getManagerId().toString()));
        vacationRepository.save(vacationMapper.map(vacationDto,manager));
    }
    public List<VacationDto> getAllVacationsForManager(Long managerId){
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(()->new ManagerNotFoundException(managerId.toString()));
        return vacationRepository.findAllByManager(manager)
                .stream()
                .map(vacationMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
