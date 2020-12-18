package org.wecancodeit.schoolteacherdemo.models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Subject {


    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    private School school;
    @ManyToMany
    private Collection<Teacher> teachers;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public School getSchool() {
        return school;
    }

    public Collection<Teacher> getTeachers() {
        return teachers;
    }

    //default constructor for jpa
    public Subject(){
    }

    public Subject(String title, String description, School school, Teacher...teachers) {
        this.title=title;
        this.description=description;
        this.school=school;
        this.teachers= new ArrayList<>(Arrays.asList(teachers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
