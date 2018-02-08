package ru.lagoshny.parser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Date: 2/8/18
 * Time: 11:06 PM
 *
 * @author Ilya_lagoshnyj@epam.com
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResourcesConfig {

    private LimitsConfig limits = new LimitsConfig();
    private ReservationsConfig reservations = new ReservationsConfig();

    public LimitsConfig getLimits() {
        return limits;
    }

    public void setLimits(LimitsConfig limits) {
        this.limits = limits;
    }

    public ReservationsConfig getReservations() {
        return reservations;
    }

    public void setReservations(ReservationsConfig reservations) {
        this.reservations = reservations;
    }
}
