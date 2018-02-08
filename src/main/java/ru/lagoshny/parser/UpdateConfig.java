package ru.lagoshny.parser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Date: 2/8/18
 * Time: 10:57 PM
 *
 * @author Ilya_lagoshnyj@epam.com
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateConfig {

    private int parallelism;
    private String delay;
    private String order;
    private String monitor;
    private String failure_action;
    private String max_failure_ratio;

    public int getParallelism() {
        return parallelism;
    }

    public void setParallelism(int parallelism) {
        this.parallelism = parallelism;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getFailure_action() {
        return failure_action;
    }

    public void setFailure_action(String failure_action) {
        this.failure_action = failure_action;
    }

    public String getMax_failure_ratio() {
        return max_failure_ratio;
    }

    public void setMax_failure_ratio(String max_failure_ratio) {
        this.max_failure_ratio = max_failure_ratio;
    }
}
