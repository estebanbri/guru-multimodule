package com.example.guru.core.model;

import org.apache.commons.lang3.StringUtils;  // ¡Reutilizando! Esto viene de la dependencia definida en guru.parent

public class Person {

    private Long id;

    private String name;

    private String dni;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        StringUtils.upperCase(name);
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
