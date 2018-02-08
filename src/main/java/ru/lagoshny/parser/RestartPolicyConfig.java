package ru.lagoshny.parser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Date: 2/8/18
 * Time: 10:58 PM
 *
 * @author Ilya_lagoshnyj@epam.com
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RestartPolicyConfig {

    private String condition;
    private String delay;
    private int max_attempts;
    private String window;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public int getMax_attempts() {
        return max_attempts;
    }

    public void setMax_attempts(int max_attempts) {
        this.max_attempts = max_attempts;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }
}
