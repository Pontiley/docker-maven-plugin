package ru.lagoshny;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 07.02.18
 * Time: 14:40
 *
 * @author Ilya_lagoshnyj@epam.com
 * @version 1.0
 */
@Mojo(name = "up", threadSafe = true)
public class DockerComposeUpMojo extends AbstractDockerCompose {

    @Parameter(defaultValue = "false")
    private boolean needBuild;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        if (skip) {
            getLog().info("Skipping execution");
            return;
        }

        List<String> args = new ArrayList<>();
        args.add(Command.UP.getValue());

        if (detachedMode) {
            getLog().info("Running in detached mode");
            args.add("-d");
        }

        if (needBuild) {
            getLog().info("Running in build mode");
            args.add("--build");
        }

        args.add(containerName);

        super.execute(args);
    }

    public boolean isNeedBuild() {
        return needBuild;
    }

}
