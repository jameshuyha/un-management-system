package org.example;

import java.util.List;
import java.util.Objects;

public class Peacekeeping extends Mission {
    private int troopCount;

    public Peacekeeping() {
        super();
        this.troopCount = 0;
    }

    public Peacekeeping(String id, String objective, PriorityLevel priorityLevel, double budget, List<Staff> assignedStaff, int troopCount) {
        super(id, objective, priorityLevel, budget, assignedStaff);
        this.troopCount = troopCount;
    }

    /**
     * prints details of missions
     * including ID, objective, priority level, budget, staff assigned
     * and troop count
     */
    @Override
    public void displayDetails() {
        // TODO
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
