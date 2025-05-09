package org.example;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Peacekeeping extends Mission {
    private int troopCount;

    public Peacekeeping() {
        super();
        this.troopCount = 0;
    }

    public Peacekeeping(String id, String objective, PriorityLevel priorityLevel, double budget, boolean launchStatus, List<Staff> assignedStaff, int troopCount) {
        super(id, objective, priorityLevel, budget, launchStatus, assignedStaff);
        this.troopCount = troopCount;
    }

    /**
     * prints details of all peacekeeping missions
     * including ID, objective, priority level, budget, launch status, staff assigned
     * and troop count
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

        System.out.println("Troop Count: " + getTroopCount());
        System.out.println(); // line break between missions for readability
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Peacekeeping that = (Peacekeeping) o;
        return troopCount == that.troopCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), troopCount);
    }

    @Override
    public String toString() {
        return "Peacekeeping{" +
                "troopCount=" + troopCount + ", " +
                super.toString() +
                '}';
    }

    public int getTroopCount() {
        return troopCount;
    }

    public void setTroopCount(int troopCount) {
        this.troopCount = troopCount;
    }
}
