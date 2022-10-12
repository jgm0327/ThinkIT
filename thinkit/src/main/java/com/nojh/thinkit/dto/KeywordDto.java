package com.nojh.thinkit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nojh.thinkit.entity.Keyword;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Keyword} entity
 */

public record KeywordDto(@JsonProperty(value="keywords") List<String> concepts) implements Serializable {
}