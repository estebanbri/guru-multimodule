package com.example.guru.api.service;

import com.example.guru.core.model.Person;
import org.apache.commons.lang3.StringUtils; // ¡Reutilizando! Esto viene de la dependencia definida en guru.parent

public class ServiceImpl {

    public void changePersonName(String name) {
        String upperCaseName = StringUtils.upperCase(name);
        Person person = new Person(); // ¡Reutilizando! Person es una clase definida dentro del modulo guru-core
        person.setName(upperCaseName);
        // ...
    }

}
