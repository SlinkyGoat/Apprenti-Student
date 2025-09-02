package org.example;

public class Person {

    private String firstName;
    private String lastName;

    public Person(){
        this.firstName = "NO_FIRST_NAME";
        this.lastName = "NO_LAST_NAME";
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
