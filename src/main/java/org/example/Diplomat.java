package org.example;

import java.util.Objects;

public class Diplomat extends Staff {
    private String country;

    public Diplomat() {
        super();
        this.country = "NaN";
    }

    public Diplomat(String name, String nationality, SecurityLevel securityLevel, String country) {
        super(name, nationality, securityLevel);
        this.country = country;
    }

    /**
     * Display staff details, including name, nationality, security level
     * and country of representation
     */
    @Override
    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Nationality: " + getNationality());
        System.out.println("Security Level: " + getSecurityLevel());
        System.out.println("Country of Representation: " + country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Diplomat diplomat = (Diplomat) o;
        return Objects.equals(country, diplomat.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country);
    }

    @Override
    public String toString() {
        return "Diplomat{" +
                "country='" + country + '\'' + ", " +
                super.toString() +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
