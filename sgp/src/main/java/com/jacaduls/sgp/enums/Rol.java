package com.jacaduls.sgp.enums;

public enum Rol {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_OPERARIO("ROLE_OPERARIO");

    final String value;

    Rol(String value) {
        this.value = value;
    }
}
