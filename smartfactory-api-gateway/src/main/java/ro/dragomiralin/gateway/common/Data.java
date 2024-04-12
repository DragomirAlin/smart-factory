package ro.dragomiralin.gateway.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.Map;

@lombok.Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Data {
    private String id;
    private String topic;
    private Map<String, Object> payload;
    private Date arriveAt;
    private Metadata metadata;
}
