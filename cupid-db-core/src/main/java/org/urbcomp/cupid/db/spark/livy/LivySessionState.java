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

    not_started("not_started"),
    starting("starting"),
    idle("idle"),
    busy("busy"),
    shutting_down("shutting_down"),
    error("error"),
    dead("dead"),
    killed("killed"),
    success("success");

    LivySessionState(String value) {}

    public boolean ok() {
        return this == idle || this == busy;
    }
}
