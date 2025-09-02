package org.example;

public class Student extends Person{
    private double GPA;
    private Person homeroomTeacher;

    Student(){
        super();
        this.GPA = 0.0;
        this.homeroomTeacher = new Person();
    }

    Student(Person student, double GPA, Person homeroomTeacher){
        super(student.getFirstName(), student.getLastName());
        this.GPA = GPA;
        this.homeroomTeacher = homeroomTeacher;
    }

    Student(String firstName, String lastName, double GPA, Person homeroomTeacher){
        super(firstName, lastName);
        this.GPA = GPA;
        this.homeroomTeacher = homeroomTeacher;
    }

    public Person getHomeroomTeacher() {
        return homeroomTeacher;
    }

    public void setHomeroomTeacher(Person homeroomTeacher) {
        this.homeroomTeacher = homeroomTeacher;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

}
