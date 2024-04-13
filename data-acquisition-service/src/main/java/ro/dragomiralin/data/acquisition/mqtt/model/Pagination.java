package ro.dragomiralin.data.acquisition.mqtt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Pagination {
    private int size;
    private int page;
}
