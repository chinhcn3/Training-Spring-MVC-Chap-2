package demo.web.model;

import java.io.Serializable;

public class Person implements Serializable{
    public int id;
    public String fullname;
    public String phone;
    public String email;

    public Person() {
    }

    public Person(int id, String fullname, String phone, String email) {
        this.id = id;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
