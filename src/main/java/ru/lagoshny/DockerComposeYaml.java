package ru.lagoshny;

import lombok.*;

import java.util.List;

/**
 * Date: 07.02.18
 * Time: 15:41
 *
 * @author Ilya_lagoshnyj@epam.com
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DockerComposeYaml {
    private String image;
    private String build;

    private String dockerfile;
    private String command;
    private String container_name;

    private List<String> links;
    private List<String> ports;
    private List<String> expose;
    private List<String> volumes;
    private List<String> environment;


}
