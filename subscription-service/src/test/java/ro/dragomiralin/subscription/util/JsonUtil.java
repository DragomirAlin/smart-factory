package ro.dragomiralin.subscription.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;

public class JsonUtil {

    public static String asJsonString(final Object obj) {
        try {
            return JacksonObjectMapper.OBJECT_MAPPER.getObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T getMvcResult(MvcResult result, TypeReference<T> type) throws Exception {
        return fromJsonString(result.getResponse().getContentAsString(), type);
    }

    public static <T> T fromJsonString(final String json, TypeReference<T> type) {
        try {
            return JacksonObjectMapper.OBJECT_MAPPER.getObjectMapper().readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    enum JacksonObjectMapper {
        OBJECT_MAPPER;

        private final ObjectMapper objectMapper = new ObjectMapper();

        public ObjectMapper getObjectMapper() {
            return objectMapper;
        }
    }
}
