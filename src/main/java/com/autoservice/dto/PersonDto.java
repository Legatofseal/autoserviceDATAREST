package com.autoservice.dto;

import com.autoservice.model.Person;

public class PersonDto {

    private Long id;

    private String personName;

    private Double personAge;

    public static PersonDto fromPerson(Person person) {
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setPersonAge(person.getPersonAge());
        dto.setPersonName(person.getPersonName());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public double getPersonAge() {
        return personAge;
    }

    public void setPersonAge(double personAge) {
        this.personAge = personAge;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", personName=" + personName + ", personAge=" + personAge + "]";
    }
}

