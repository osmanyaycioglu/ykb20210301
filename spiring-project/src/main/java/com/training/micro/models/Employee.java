package com.training.micro.models;

import java.time.LocalDate;

public class Employee {

    private String    name;
    private String    surname;
    private LocalDate birthday;
    private EGender   gender;
    private Integer   weight;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(final LocalDate birthdayParam) {
        this.birthday = birthdayParam;
    }

    public EGender getGender() {
        return this.gender;
    }

    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    @Override
    public String toString() {
        return "Employee [name="
               + this.name
               + ", surname="
               + this.surname
               + ", birthday="
               + this.birthday
               + ", gender="
               + this.gender
               + ", weight="
               + this.weight
               + "]";
    }


}
