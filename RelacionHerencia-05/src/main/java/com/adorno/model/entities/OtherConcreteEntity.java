package com.adorno.model.entities;

import jakarta.persistence.Entity;

@Entity
public class OtherConcreteEntity extends AbstractEntity {

    private String surname;

    public OtherConcreteEntity() {
    }

    public OtherConcreteEntity(String nick, String description, String surname) {
        super(nick, description);
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

}
