package com.destructio.scoringbpmnexample.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class ScoringResponseDto {
    private Boolean result;
    private List<Map<String, Object>> comments;
}
