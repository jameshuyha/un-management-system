package org.example;

import java.util.Objects;

public abstract class Staff implements Comparable<Staff> {
    protected String name;
    protected String nationality;
    protected SecurityLevel securityLevel;

    public Staff() {
        this.name = "NaN";
        this.nationality = "NaN";
        this.securityLevel = SecurityLevel.FIVE;
    }

    public Staff(String name, String nationality, SecurityLevel securityLevel) {
        this.name = name;
        this.nationality = nationality;
        this.securityLevel = securityLevel;
    }

    /**
     * assigns staff member to a mission
     * @param mission mission to assign staff to
     */
    public void assignTo(Mission mission) {
        // TODO
    }

    /**
     * Display staff details, including name, nationality, and security level
     */
    public void displayDetails() {
        // TODO
    }

    @Override
    public int compareTo(Staff staff) {
        return name.compareTo(staff.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(name, staff.name) && Objects.equals(nationality, staff.nationality) && securityLevel == staff.securityLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationality, securityLevel);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", securityLevel=" + securityLevel +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(SecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }

    public enum SecurityLevel {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE
    }
}
