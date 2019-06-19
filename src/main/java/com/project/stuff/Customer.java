package com.project.stuff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @Column(name = "custID", unique = true)
    private int id;


    @Column(name = "firstname", nullable = false)
    private String fname;

    @Column(name = "lastname", nullable = false)
    private String lname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname(){
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname(){
        return lname;
    }

    public void setLname(String lname){
        this.lname = lname;
    }

}


