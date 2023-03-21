package com.github.fullstorydev.grpcurl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ExitCodeMessage {
    @JsonIgnore
    protected static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    private Integer exitCode;
    private String message;

    @SneakyThrows(JsonProcessingException.class)
    protected static ExitCodeMessage fromJson(String json) {

        return objectMapper.readValue(json, ExitCodeMessage.class);
    }


}
