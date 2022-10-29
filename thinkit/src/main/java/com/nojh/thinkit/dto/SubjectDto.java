package com.nojh.thinkit.dto;

import com.nojh.thinkit.entity.Subject;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Subject} entity
 */

public record SubjectDto(int id, String name, List<ProblemDto> problems,
                         List<KeywordDto> keywords) implements Serializable {
}