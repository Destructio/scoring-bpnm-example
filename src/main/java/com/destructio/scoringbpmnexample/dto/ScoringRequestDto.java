package com.destructio.scoringbpmnexample.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ScoringRequestDto {
    private String inn;
    private String region;
    private Long capital;
}
