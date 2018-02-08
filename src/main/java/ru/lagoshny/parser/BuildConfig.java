package ru.lagoshny.parser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BuildConfig {

    private String context;
    private Map<String, String> args = new HashMap<>();
    private String dockerfile;
    private List<String> cache_from = new ArrayList<>();
    private List<String> labels = new ArrayList<>();
    private int shm_size;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }

    public String getDockerfile() {
        return dockerfile;
    }

    public void setDockerfile(String dockerfile) {
        this.dockerfile = dockerfile;
    }

    public List<String> getCache_from() {
        return cache_from;
    }

    public void setCache_from(List<String> cache_from) {
        this.cache_from = cache_from;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public int getShm_size() {
        return shm_size;
    }

    public void setShm_size(int shm_size) {
        this.shm_size = shm_size;
    }
}
