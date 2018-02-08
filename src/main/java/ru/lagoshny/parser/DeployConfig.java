package ru.lagoshny.parser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2/8/18
 * Time: 10:56 PM
 *
 * @author Ilya_lagoshnyj@epam.com
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeployConfig {

    private int replicas;
    private UpdateConfig update_config = new UpdateConfig();
    private RestartPolicyConfig restart_policy = new RestartPolicyConfig();
    private PlacementConfig placement = new PlacementConfig();
    private String mode;
    private Map<String, String> labels = new HashMap<>();
    private String endpoint_mode;

    public int getReplicas() {
        return replicas;
    }

    public void setReplicas(int replicas) {
        this.replicas = replicas;
    }

    public UpdateConfig getUpdate_config() {
        return update_config;
    }

    public void setUpdate_config(UpdateConfig update_config) {
        this.update_config = update_config;
    }

    public RestartPolicyConfig getRestart_policy() {
        return restart_policy;
    }

    public void setRestart_policy(RestartPolicyConfig restart_policy) {
        this.restart_policy = restart_policy;
    }

    public PlacementConfig getPlacement() {
        return placement;
    }

    public void setPlacement(PlacementConfig placement) {
        this.placement = placement;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }
}
