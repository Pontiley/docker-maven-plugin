package ru.lagoshny.parser;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RootConfig {

    private String version;

    private Map<String, ServiceConfig> services = new HashMap<>();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, ServiceConfig> getServices() {
        return services;
    }

    public void setServices(Map<String, ServiceConfig> services) {
        this.services = services;
    }

}
