package org.example;

import java.util.Objects;

public class Intern extends Staff {
    private String university;

    public Intern() {
        super();
        this.university = "NaN";
    }

    public Intern(String name, String nationality, SecurityLevel securityLevel, String university) {
        super(name, nationality, securityLevel);
        this.university = university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Intern intern = (Intern) o;
        return Objects.equals(university, intern.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university);
    }

    @Override
    public String toString() {
        return "Intern{" +
                "university='" + university + '\'' + ", " +
                super.toString() +
                '}';
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
