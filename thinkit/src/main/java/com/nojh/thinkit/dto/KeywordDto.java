package com.nojh.thinkit.dto;

import com.nojh.thinkit.entity.Keyword;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Keyword} entity
 */

public record KeywordDto(int id, String name, List<ConceptDto> concepts) implements Serializable {
}