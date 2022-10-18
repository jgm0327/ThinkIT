package com.nojh.thinkit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FeedbackDto(@JsonProperty(value = "isSuccess") boolean isSuccess){
}
