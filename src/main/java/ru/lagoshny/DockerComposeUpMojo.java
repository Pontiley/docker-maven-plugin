package ru.lagoshny;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

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
//        args.add("-d");

        args.add(containerName);

//        args.add("--no-color");

        super.execute(args);
    }

}
