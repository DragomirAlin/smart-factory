package ro.dragomialin.monitor.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public  class Metadata {
    private String macAddress;
    private DeviceType device;
    private String location;
    private Date timestamp;
    private String maintainer;
    private String lastMaintain;
    private Acqusition acquisition;

    public enum Acqusition {
        DTH22, MQ2
    }
}