package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public abstract class Mission implements Reportable {
    protected String id;
    protected String objective;
    protected PriorityLevel priorityLevel;
    protected double budget;
    protected List<Staff> assignedStaff;

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
     * assigns staff members to a mission
     * @param staff staff member to add
     * @return whether the staff member could be added
     * based on their current presence in the mission
     */
    public boolean addStaff(Staff staff) {
        if (!assignedStaff.contains(staff)) {
            assignedStaff.add(staff);
            System.out.println(staff.name + " has been added to the mission.");

            return true;
        }

        System.out.println(staff.name + " is already assigned to this mission.");
        return false;
    }

    /**
     * removes staff member from a mission
     * @param staff staff member to remove
     * @return whether the staff member could be removed
     * based on their current presence in the mission
     */
    public boolean removeStaff(Staff staff) {
        if (assignedStaff.contains(staff)) {
            assignedStaff.remove(staff);
            System.out.println(staff.name + " has been removed from the mission.");

            return true;
        }

        System.out.println(staff.name + " is not a current member of this mission and thus could not be removed.");
        return false;
    }

    /**
     * reads a CSV mission report
     * @return mission report details
     * including ID, objective, priority level, budget, and staff assigned
     * including troop count or aid items depending on instance
     */
    public String readReport() {
        // TODO
        return "temporary"; // so I can run my test cases without getting an error
    }

    /**
     * writes a CSV mission report, including details such as
     * ID, objective, priority level, budget, staff assigned
     * including troop count or aid items depending on instance
     */
    public void generateReport() {
        // TODO
    }

    public abstract void displayDetails();

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
        // TODO: for-loop through the assigned staff

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

    public static class MissionComparator implements Comparator<Mission> {
        private final String identifier;

        public MissionComparator(String identifier) {
            this.identifier = identifier;
        }

        @Override
        public int compare(Mission m1, Mission m2) {
             return switch (identifier) {
                case "id" -> m1.id.compareTo(m2.id);
                case "budget" -> Double.compare(m1.budget, m2.budget);
                case "priority" -> m1.priorityLevel.compareTo(m2.priorityLevel);
                default -> m1.objective.compareTo(m2.objective);
            };
        }
    }

    public enum PriorityLevel {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE
    }
}
