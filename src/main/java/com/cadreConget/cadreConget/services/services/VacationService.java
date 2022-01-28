package com.cadreConget.cadreConget.services.services;

import com.cadreConget.cadreConget.exception.ManagerNotFoundException;
import com.cadreConget.cadreConget.model.Manager;
import com.cadreConget.cadreConget.model.Vacation;
import com.cadreConget.cadreConget.repository.ManagerRepository;
import com.cadreConget.cadreConget.repository.VacationRepository;
import com.cadreConget.cadreConget.repository.VacationRepository;
import com.cadreConget.cadreConget.web.dto.VacationDto;
import com.cadreConget.cadreConget.web.dto.VacationDto;
import com.cadreConget.cadreConget.web.mappers.VacationMapper;
import com.cadreConget.cadreConget.web.mappers.VacationMapper;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@AllArgsConstructor
@Service
public class VacationService {
    private final VacationRepository vacationRepository;
    private final ManagerRepository managerRepository;
    private final VacationMapper vacationMapper;

    public Vacation save(VacationDto vacationDto){
        Manager manager = managerRepository.findById(vacationDto.getManagerId())
                .orElseThrow(()-> new ManagerNotFoundException(
                        vacationDto.getManagerId().toString()));
        return vacationRepository.save(vacationMapper.toVacation(vacationDto, manager));
    }

    public List<VacationDto> getAllVacationsForManager(Long managerId){
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(()-> new ManagerNotFoundException(managerId.toString()));
        return vacationRepository.findAllByManager(manager)
                .stream()
                .map(vacationMapper::toVacationDto)
                .collect(Collectors.toList());
    }
    public void deleteById(Long id){
        vacationRepository.deleteById(id);
    }
}
