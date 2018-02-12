package ru.lagoshny;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2/12/18
 * Time: 9:31 PM
 *
 * @author Ilya_lagoshnyj@epam.com
 * @version 1.0
 */
@Mojo(name = "build", threadSafe = true)
public class DockerComposeBuildMojo extends AbstractDockerCompose {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (skip) {
            getLog().info("Skipping execution");
            return;
        }

        List<String> args = new ArrayList<>();

        args.add(Command.BUILD.getValue());
        args.add(containerName);

        super.execute(args);
    }

}
