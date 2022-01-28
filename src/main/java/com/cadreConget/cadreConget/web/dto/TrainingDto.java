package com.cadreConget.cadreConget.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TrainingDto {
    private String theme;
    private Date startDate;
    private Date endDate;
    private Long managerId;
}
