package com.cadreConget.cadreConget.web.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VacationDto {
    private Long id;
    private Long managerId;
    private Instant startDate;
    private Instant endDate;
    private String username;
}
