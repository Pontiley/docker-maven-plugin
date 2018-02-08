package ru.lagoshny.parser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2/8/18
 * Time: 11:00 PM
 *
 * @author Ilya_lagoshnyj@epam.com
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlacementConfig {

    private List<String> constraints = new ArrayList<>();

    public List<String> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<String> constraints) {
        this.constraints = constraints;
    }
}

