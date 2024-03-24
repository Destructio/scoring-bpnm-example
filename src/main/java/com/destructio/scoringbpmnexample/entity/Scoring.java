package com.destructio.scoringbpmnexample.entity;

import com.destructio.scoringbpmnexample.dto.ScoringRequestDto;
import com.destructio.scoringbpmnexample.dto.ScoringResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static org.hibernate.type.SqlTypes.JSON;

@Entity
@Getter
@Setter
@Table(name = "scorings")
public class Scoring {
    @Id
    @UuidGenerator
    private UUID id;

    @JdbcTypeCode(JSON)
    private ScoringRequestDto scoringRequest;

    @JdbcTypeCode(JSON)
    private ScoringResponseDto scoringResults;
}
