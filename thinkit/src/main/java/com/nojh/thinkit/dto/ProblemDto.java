package com.nojh.thinkit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nojh.thinkit.entity.Problem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Problem} entity
 */

public record ProblemDto(@JsonProperty(value="problems") List<String> title,
                         @JsonProperty(value="selects") List<String> content) implements Serializable {
}