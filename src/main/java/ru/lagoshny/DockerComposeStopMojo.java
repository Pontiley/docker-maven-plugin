package ru.lagoshny;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 07.02.18
 * Time: 16:08
 *
 * @author Ilya_lagoshnyj@epam.com
 * @version 1.0
 */
@Mojo(name = "stop", threadSafe = true)
public class DockerComposeStopMojo extends MyFirstMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (skip) {
            getLog().info("Skipping execution");
            return;
        }

        List<String> args = new ArrayList<>();

        args.add(Command.STOP.getValue());

        if (removeVolumes) {
            getLog().info("Removing volumes");
            args.add("-v");
        }

        args.add(containerName);

        super.execute(args);
    }

}
