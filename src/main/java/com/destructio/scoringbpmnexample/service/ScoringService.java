package com.destructio.scoringbpmnexample.service;

import com.destructio.scoringbpmnexample.dto.ScoringRequestDto;
import com.destructio.scoringbpmnexample.dto.ScoringResponseDto;
import com.destructio.scoringbpmnexample.entity.Scoring;
import com.destructio.scoringbpmnexample.repository.ScoringRepository;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScoringService {
    private final DmnEngine dmnEngine;
    private final DmnDecision scoringDecision;
    private final ScoringRepository scoringRepository;

    public ScoringResponseDto getScoringResults(ScoringRequestDto scoringRequest) {

        VariableMap variables = Variables
                .putValue("inn", scoringRequest.getInn())
                .putValue("region", scoringRequest.getRegion())
                .putValue("capital", scoringRequest.getCapital())
                ;

        DmnDecisionTableResult dmnDecisionRuleResults = dmnEngine.evaluateDecisionTable(scoringDecision, variables);

        ScoringResponseDto scoringResponse = ScoringResponseDto.builder()
                .result(dmnDecisionRuleResults.getFirstResult().getFirstEntry())
                .comments(dmnDecisionRuleResults.getResultList())
                .build();

        Scoring scoring = new Scoring();
        scoring.setId(UUID.randomUUID());
        scoring.setScoringRequest(scoringRequest.toString());
        scoring.setScoringResults(scoringResponse.toString());
        scoringRepository.save(scoring);

        return scoringResponse;
    }
}
