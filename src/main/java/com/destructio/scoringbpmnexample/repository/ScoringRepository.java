package com.destructio.scoringbpmnexample.repository;

import com.destructio.scoringbpmnexample.entity.Scoring;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.UUID;

public interface ScoringRepository extends ElasticsearchRepository<Scoring, UUID> {
}