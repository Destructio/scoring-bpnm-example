package com.destructio.scoringbpmnexample.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@Getter
@Setter
@Document(indexName = "scorings-index")
public class Scoring {
    @Id
    private UUID id;
    private String scoringRequest;
    private String scoringResults;
}
