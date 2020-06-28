package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class JSONConverter {

    final Logger logger = LoggerFactory.getLogger(JSONConverter.class);

    public String getJSONObject() {
        String resultJson = "Error by convertign";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            resultJson = objectMapper.writeValueAsString(this);
        } catch (Exception exception) {
            logger.error("Error by convertrig the object to json");
        }

        return resultJson;
    }

}
