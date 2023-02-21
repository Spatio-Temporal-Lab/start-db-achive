/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.spark.livy;

/**
 * @author jimo
 **/
public enum LivySessionState {

    NOT_STARTED("not_started"),
    STARTING("starting"),
    IDLE("idle"),
    BUSY("busy"),
    SHUTTING_DOWN("shutting_down"),
    ERROR("error"),
    DEAD("dead"),
    KILLED("killed"),
    SUCCESS("success");

    private String value;

    LivySessionState(String value) {
        this.value = value;
    }

    public boolean ok() {
        return this == IDLE || this == BUSY;
    }
}
