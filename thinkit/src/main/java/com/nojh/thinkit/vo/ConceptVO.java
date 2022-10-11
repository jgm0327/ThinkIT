package com.nojh.thinkit.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConceptVO {
    @JsonProperty(value="keyword_content")
    private String content;
}
