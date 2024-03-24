package com.destructio.scoringbpmnexample.repository;

import com.destructio.scoringbpmnexample.entity.Scoring;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScoringRepository extends JpaRepository<Scoring, UUID> {
}