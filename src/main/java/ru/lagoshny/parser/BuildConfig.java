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
}
