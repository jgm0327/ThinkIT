package com.nojh.thinkit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nojh.thinkit.entity.Problem;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Problem} entity
 */

public record InterviewProblemDto(@JsonProperty(value="selects") List<String> content) implements Serializable {
}