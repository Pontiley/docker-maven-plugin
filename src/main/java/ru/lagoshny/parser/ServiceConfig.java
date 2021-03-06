package ru.lagoshny.parser;


import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceConfig {

    private Boolean stdin_open;
    private Boolean tty;
    private String image;
    private BuildConfig build = new BuildConfig();
    private String container_name;
    private List<String> volumes = new ArrayList<>();
    private List<String> ports = new ArrayList<>();
    private List<String> entrypoint = new ArrayList<>();
    private List<String> networks = new ArrayList<>();
    private DeployConfig deploy = new DeployConfig();
    private List<String>  depends_on = new ArrayList<>();

    public Boolean getTty() {
        return tty;
    }

    public void setTty(Boolean tty) {
        this.tty = tty;
    }

    public Boolean getStdin_open() {
        return stdin_open;
    }

    public void setStdin_open(Boolean stdin_open) {
        this.stdin_open = stdin_open;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BuildConfig getBuild() {
        return build;
    }

    public void setBuild(BuildConfig build) {
        this.build = build;
    }

    public String getContainer_name() {
        return container_name;
    }

    public void setContainer_name(String container_name) {
        this.container_name = container_name;
    }

    public List<String> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<String> volumes) {
        this.volumes = volumes;
    }

    public List<String> getPorts() {
        return ports;
    }

    public void setPorts(List<String> ports) {
        this.ports = ports;
    }

    public List<String> getEntrypoint() {
        return entrypoint;
    }

    public void setEntrypoint(List<String> entrypoint) {
        this.entrypoint = entrypoint;
    }

    public List<String> getNetworks() {
        return networks;
    }

    public void setNetworks(List<String> networks) {
        this.networks = networks;
    }

    public DeployConfig getDeploy() {
        return deploy;
    }

    public void setDeploy(DeployConfig deploy) {
        this.deploy = deploy;
    }
}
