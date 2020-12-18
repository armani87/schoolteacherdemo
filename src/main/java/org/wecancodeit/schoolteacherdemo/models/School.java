package org.wecancodeit.schoolteacherdemo.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class School {

    @Id
    @GeneratedValue
    private  Long id;
    private String location;
    @OneToMany(mappedBy = "school")
    private Collection<Subject> subjects;

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Collection<Subject> getSubjects() {
        return subjects;
    }

    //default constructor for jpa
    public School(){

    }

    public School(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(id, school.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
