package com.verizon.bnc.bncsimulator.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.verizon.bnc.bncsimulator.annotations.Util;

@Util
public class JsonUtil {

    public String formatJson(final String response) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String result = response;
        try {
            Object obj = mapper.readValue(response, Object.class);
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
