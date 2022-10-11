package com.nojh.thinkit.dto;

import com.nojh.thinkit.entity.Problem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link Problem} entity
 */

public record ProblemDto(int id) implements Serializable {
}