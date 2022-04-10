package com.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private final int id;
    private final String Name;
    private int age;

    @JsonCreator
    public Person(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("age") int age) {
        this.id = id;
        Name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return Name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
            "id=" + id +
            ", Name='" + Name + '\'' +
            ", age=" + age +
            '}';
    }
}
