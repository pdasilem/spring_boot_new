package ru.pdasilem.spring_boot_new.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "userstable")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surName;
    @Column(name = "age")
    private int age;
    @Column(name = "profession")
    private String profession;
    @Column(name = "yearsexp")
    private int yearsExp;

    public UserModel(){}

    public UserModel(String name, String surName, int age, String profession, int yearsExp) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.profession = profession;
        this.yearsExp = yearsExp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getYearsExp() {
        return yearsExp;
    }

    public void setYearsExp(int yearsExp) {
        this.yearsExp = yearsExp;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", yearsExp=" + yearsExp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return age == userModel.age && yearsExp == userModel.yearsExp && Objects.equals(id, userModel.id) && Objects.equals(name, userModel.name) && Objects.equals(surName, userModel.surName) && Objects.equals(profession, userModel.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName, age, profession, yearsExp);
    }
}