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

    public Humanitarian(String id, String objective, PriorityLevel priorityLevel, double budget, List<Staff> assignedStaff, Map<String, Integer> aidItems) {
        super(id, objective, priorityLevel, budget, assignedStaff);
        this.aidItems = aidItems;
    }

    /**
     * prints details of missions
     * including ID, objective, priority level, budget, staff assigned
     * and aid items
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
