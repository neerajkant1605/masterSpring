package com.example.masterSpring.Model;

public class customer {

    private int Id;
    private String firstName;
    private String lastName;
    private String city;

    public customer() {
    }

    public customer(int id, String firstName, String lastName, String city) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
