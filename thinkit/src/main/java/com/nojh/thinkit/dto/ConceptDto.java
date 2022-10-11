package com.nojh.thinkit.dto;

import com.nojh.thinkit.entity.Concept;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link Concept} entity
 */
public record ConceptDto(int id, String content) implements Serializable {
}