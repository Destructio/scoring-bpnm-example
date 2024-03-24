package com.destructio.scoringbpmnexample.controller;

import com.destructio.scoringbpmnexample.service.ScoringService;
import com.destructio.scoringbpmnexample.dto.ScoringRequestDto;
import com.destructio.scoringbpmnexample.dto.ScoringResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/scoring")
@RequiredArgsConstructor
public class ScoringController {
    private final ScoringService scoringService;

    @PostMapping("")
    public ScoringResponseDto getScoring(@RequestBody ScoringRequestDto scoringRequest){
        return scoringService.getScoringResults(scoringRequest);
    }

}
