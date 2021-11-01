package ru.folder.models;


import java.util.List;

public class User {
    private Integer id;
    private String first_name;
    private String last_name;
    private List<Car> cars;
    private Integer age;


    public User(Integer id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public User() {
    }

    public User(String first_name, String last_name, Integer age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public User(Integer id, String first_name, String last_name, List<Car> cars) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.cars = cars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", cars=" + cars +
                ", age=" + age +
                '}';
    }
}