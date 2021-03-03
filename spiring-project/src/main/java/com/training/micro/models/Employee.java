package com.training.micro.models;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.micro.validation.StartWith;

@XmlRootElement
public class Employee {

    @NotEmpty(message = "name boş olamaz")
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    private String    name;
    @StartWith(value = "soy", message = "surname soy ile başlamalı")
    @NotEmpty(message = "surname boş olamaz")
    @Size(min = 3, max = 30, message = "surname 3 ile 30 arasında olmalı")
    private String    surname;
    @NotNull
    @Past
    private LocalDate birthday;
    @NotNull
    private EGender   gender;
    @Max(300)
    @Min(80)
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
