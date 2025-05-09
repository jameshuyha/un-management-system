package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Humanitarian extends Mission {
    private Map<String, Integer> aidItems;

    public Humanitarian() {
        super();
        this.aidItems = new HashMap<>();
    }

    public Humanitarian(String id, String objective, PriorityLevel priorityLevel, double budget, boolean launchStatus, List<Staff> assignedStaff, Map<String, Integer> aidItems) {
        super(id, objective, priorityLevel, budget, launchStatus, assignedStaff);
        this.aidItems = aidItems;
    }

    /**
     * prints details of all humanitarian missions
     * including ID, objective, priority level, budget, launch status, staff assigned
     * and aid items
     */
    @Override
    public void displayDetails() {
        System.out.println("Mission ID: " + getId());
        System.out.println("Objective: " + getObjective());
        System.out.println("Priority Level: " + getPriorityLevel());
        System.out.println("Budget: $" + getBudget());
        System.out.println("Launch Status: " + (getLaunchStatus() ? "Launched" : "Unlaunched"));

        System.out.println("Assigned Staff: ");
        if (getAssignedStaff().isEmpty()) {
            System.out.println("No staff assigned.");
        } else {
            for (Staff staff : getAssignedStaff()) {
                System.out.println("- " + staff.getName());
            }
        }

        System.out.println("Aid Items: ");
        if (aidItems.isEmpty()) {
            System.out.println("No aid items.");
        } else {
            for (Map.Entry<String, Integer> entry : aidItems.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }
        }

        System.out.println(); // line break between missions for readability
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Humanitarian that = (Humanitarian) o;
        return Objects.equals(aidItems, that.aidItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), aidItems);
    }

    @Override
    public String toString() {
        return "Humanitarian{" +
                "aidItems=" + aidItems + ", " +
                super.toString() +
                '}';
    }

    public Map<String, Integer> getAidItems() {
        return aidItems;
    }

    public void setAidItems(Map<String, Integer> aidItems) {
        this.aidItems = aidItems;
    }
}
