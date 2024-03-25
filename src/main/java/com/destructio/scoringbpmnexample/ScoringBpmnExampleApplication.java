package com.destructio.scoringbpmnexample;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class ScoringBpmnExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoringBpmnExampleApplication.class, args);
    }

    @Bean
    public DmnEngine dmnEngine() {
        return DmnEngineConfiguration
                .createDefaultDmnEngineConfiguration()
                .buildEngine();
    }

    @Bean
    public DmnDecision scoringDecision(DmnEngine dmnEngine) throws IOException {
        InputStream inputStream = Files.newInputStream(Paths.get("src/main/resources/scoring.dmn"));
        return dmnEngine.parseDecision("Decision_0s11vyg", inputStream);
    }
}
