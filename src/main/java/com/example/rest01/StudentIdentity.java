package com.example.rest01;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class StudentIdentity implements Serializable {
    private String name;
    private int id;
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

    public StudentIdentity(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public StudentIdentity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentIdentity)) return false;
        StudentIdentity identity = (StudentIdentity) o;
        return getId() == identity.getId() &&
                getName().equals(identity.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }
}
