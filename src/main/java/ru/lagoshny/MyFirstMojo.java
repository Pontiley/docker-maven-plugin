package ru.lagoshny;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;
import org.codehaus.plexus.util.IOUtil;
import org.codehaus.plexus.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Date: 07.02.18
 * Time: 14:32
 *
 * @author Ilya_lagoshnyj@epam.com
 * @version 1.0
 */
abstract class MyFirstMojo extends AbstractMojo {

    /**
     * Remove volumes on down
     */
    @Parameter(defaultValue = "false", property = "dockerCompose.removeVolumes")
    boolean removeVolumes;

    /**
     * Run in detached mode
     */
    @Parameter(defaultValue = "false", property = "dockerCompose.detached")
    protected boolean detachedMode;

    /**
     * The location of the Compose file
     */
    @Parameter(defaultValue = "${project.basedir}/src/main/resources/docker-compose.yml", property = "dockerCompose.file")
    private String composeFile;

    /**
     * The Compose Api Version
     */
    @Parameter(property = "dockerCompose.apiVersion")
    private ComposeApiVersion apiVersion;

    /**
     * Verbose
     */
    @Parameter(defaultValue = "false", property = "dockerCompose.verbose")
    private boolean verbose;

    /**
     * Skip
     */
    @Parameter(defaultValue = "false", property = "dockerCompose.skip")
    boolean skip;

    @Parameter()
    String appName;

    @Parameter()
    String containerName;

    public void execute(List<String> args) throws MojoExecutionException, MojoFailureException {

        ProcessBuilder pb = buildProcess(args);

        getLog().info("Running: " + StringUtils.join(pb.command().iterator(), " "));

        try {
            Process p = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            while ((line = br.readLine()) != null)
                getLog().info(line);

            int ec = p.waitFor();

            if (ec != 0)
                throw new RuntimeException(IOUtil.toString(p.getErrorStream()));

        } catch (Exception e) {
            throw new MojoExecutionException(e.getMessage());
        }

    }

    private ProcessBuilder buildProcess(List<String> args) {

        List<String> command = null;
        try {
            command = buildCmd(args);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProcessBuilder pb = new ProcessBuilder(command).inheritIO();

        setEnvironment(pb);

        return pb;
    }

    private List<String> buildCmd(List<String> args) throws IOException {
        String composeFilePath = Paths.get(this.composeFile).toString();


//        Yaml yaml = new Yaml(new Constructor(DockerComposeYaml.class));
//        DockerComposeYaml load = (DockerComposeYaml) yaml.load(new StringReader(composeFilePath));



//        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(composeFilePath));
//        Yaml yaml2 = new Yaml();
//        Map config = (Map) yaml2.load(streamReader);
//        getLog().error("CONTAINER NAME: " + config.get("services"));
//        getLog().error("CONTAINER NAME2: " + config.toString());





        String content = new String(Files.readAllBytes(Paths.get(composeFilePath)));
        content = StringUtils.replace(content, "${target_file}", appName);

        getLog().error("Dockerfile: " + content);


        Files.write(Paths.get(this.composeFile), content.getBytes());


        List<String> cmd = new ArrayList<>();
        cmd.add("docker-compose");
//        cmd.add("-f");
//        cmd.add(composeFilePath);

        if (verbose) {
            cmd.add("--verbose");
        }

        cmd.addAll(args);
        return cmd;
    }

    private void setEnvironment(ProcessBuilder processBuilder) {
        Map<String, String> environment = processBuilder.environment();
        if (apiVersion != null) {
            getLog().info("COMPOSE_API_VERSION: " + apiVersion.version);
            environment.put("COMPOSE_API_VERSION", apiVersion.version);
        }
    }

    enum Command {
        START("start"),
        STOP("stop"),
        UP("up"),
        DOWN("down");

        @SuppressWarnings("unused")

        private String value;

        public String getValue() {
            return value;
        }

        Command(String value) {
            this.value = value;
        }
    }

    @SuppressWarnings("unused")
    enum ComposeApiVersion {
        V1_30("1.30"),
        V1_25("1.25"),
        V1_24("1.24"),
        V1_22("1.22"),
        V1_21("1.21");

        private String version;

        ComposeApiVersion(String version) {
            this.version = version;
        }
    }

    public boolean isRemoveVolumes() {
        return removeVolumes;
    }

    public boolean isDetachedMode() {
        return detachedMode;
    }

    public String getComposeFile() {
        return composeFile;
    }

    public ComposeApiVersion getApiVersion() {
        return apiVersion;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public boolean isSkip() {
        return skip;
    }

    public String getAppName() {
        return appName;
    }

    public String getContainerName() {
        return containerName;
    }
}
