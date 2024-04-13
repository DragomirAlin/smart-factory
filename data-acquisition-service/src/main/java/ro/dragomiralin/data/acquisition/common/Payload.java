package ro.dragomiralin.data.acquisition.common;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Payload {
    private Map<String, Object> payload;
    private Metadata metadata;
}
