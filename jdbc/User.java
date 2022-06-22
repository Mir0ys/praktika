package main.java;

public class User {
    private
    int Id;
    String name;
    String surname;
    String address;
    String number_phone;
    String technique;

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public String getTechnique() {
        return technique;
    }


    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }
}

