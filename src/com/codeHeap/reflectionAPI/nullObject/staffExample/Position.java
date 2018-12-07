package com.codeHeap.reflectionAPI.nullObject.staffExample;

public class Position {
    private String title;
    private Person person;

    public Position(String title, Person employee) {
        this.title = title;
        this.person = employee;
        if (person == null) {
            this.person = Person.NULL;
        }
    }

    public Position(String title) {
        this.title = title;
        person = Person.NULL;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        if (person == null) {
            this.person = Person.NULL;
        } else {
            this.person = person;
        }
    }

    @Override
    public String toString() {
        return "Position: " + title + " " + person;
    }
}
