package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Mission implements Reportable {
    protected String id;
    protected String objective;
    protected PriorityLevel priorityLevel;
    protected double budget;
    protected List<Staff> assignedStaff;

    // DON'T FORGET COMPARATOR

    public Mission() {
        this.id = "1";
        this.objective = "NaN";
        this.priorityLevel = PriorityLevel.FIVE;
        this.budget = 0.0;
        this.assignedStaff = new ArrayList<>();
    }

    public Mission(String id, String objective, PriorityLevel priorityLevel, double budget, List<Staff> assignedStaff) {
        this.id = id;
        this.objective = objective;
        this.priorityLevel = priorityLevel;
        this.budget = budget;
        this.assignedStaff = assignedStaff;
    }

    /**
     *
     * @param staff
     */
    public void addStaff(Staff staff) {
        // TODO
    }

    /**
     *
     * @param staff
     * @return
     */
    public boolean removeStaff(Staff staff) {
        // TODO
    }

    /**
     *
     * @return
     */
    public String generateReport() {
        // TODO
    }

    /**
     * prints details of missions, including ID, objective, priority level, budget, and staff assigned
     */
    public void displayDetails() {
        // TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mission mission = (Mission) o;
        return Double.compare(budget, mission.budget) == 0 && Objects.equals(id, mission.id) && Objects.equals(objective, mission.objective) && priorityLevel == mission.priorityLevel && Objects.equals(assignedStaff, mission.assignedStaff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objective, priorityLevel, budget, assignedStaff);
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id='" + id + '\'' +
                ", objective='" + objective + '\'' +
                ", priorityLevel=" + priorityLevel +
                ", budget=" + budget +
                ", assignedStaff=" + assignedStaff +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Staff> getAssignedStaff() {
        return assignedStaff;
    }

    public void setAssignedStaff(List<Staff> assignedStaff) {
        this.assignedStaff = assignedStaff;
    }

    public enum PriorityLevel {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE
    }
}
