package com.example.rocky.userdefined.genericity;

import java.io.Serializable;

/**
 * Created by Rocky on 2016/5/24.
 */
public class Employee implements Serializable {
    String name = "";

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
