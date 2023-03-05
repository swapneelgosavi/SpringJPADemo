package com.example.springjpademo;



import javax.persistence.*;

@Entity
@NamedQuery(
        name = "custom_person_select",
        query = "SELECT p FROM Person p")
public class Person {
    @Id
    private int id;
    private String name;
    @Transient   //this will not create column in table
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
