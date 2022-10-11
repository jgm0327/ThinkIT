package com.nojh.thinkit.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class KeywordVO {
    /*@JsonProperty(value="subject")
    private String subject_name;*/

    @JsonProperty(value="keywords")
    private List<String> keywords;
}
