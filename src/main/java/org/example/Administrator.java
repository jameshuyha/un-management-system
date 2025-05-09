package org.example;

import java.util.Objects;

public class Administrator extends Staff {
    private String department;

    public Administrator() {
        super();
        this.department = "NaN";
    }

    public Administrator(String name, String nationality, SecurityLevel securityLevel, String department) {
        super(name, nationality, securityLevel);
        this.department = department;
    }

    /**
     * Display staff details, including name, nationality, security level
     * and department
     */
    @Override
    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Nationality: " + getNationality());
        System.out.println("Security Level: " + getSecurityLevel());
        System.out.println("Department: " + department);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "department='" + department + '\'' + ", " +
                super.toString() +
                '}';
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
