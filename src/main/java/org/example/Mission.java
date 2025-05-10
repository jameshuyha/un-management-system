package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public abstract class Mission implements Reportable {
    protected String id;
    protected String objective;
    protected PriorityLevel priorityLevel;
    protected double budget;
    protected boolean launchStatus;
    protected List<Staff> assignedStaff;

    public Mission() {
        this.id = "1";
        this.objective = "NaN";
        this.priorityLevel = PriorityLevel.FIVE;
        this.budget = 0.0;
        this.launchStatus = false;
        this.assignedStaff = new ArrayList<>();
    }

    public Mission(String id, String objective, PriorityLevel priorityLevel, double budget, boolean launchStatus, List<Staff> assignedStaff) {
        this.id = id;
        this.objective = objective;
        this.priorityLevel = priorityLevel;
        this.budget = budget;
        this.launchStatus = launchStatus;
        this.assignedStaff = assignedStaff;
    }

    /**
     * assigns staff members to a mission
     * @param staff staff member to add
     * @return whether the staff member could be added
     * based on their current presence in the mission or mission launch status
     */
    public boolean addStaff(Staff staff) {
        if (launchStatus) {
            System.out.println("Mission has already been launched. Staff can no longer be added");
            return false;
        }

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
     * based on their current presence in the mission or mission launch status
     */
    public boolean removeStaff(Staff staff) {
        if (launchStatus) {
            System.out.println("Mission has already been launched. Staff can no longer be removed.");
            return false;
        }

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
     * including ID, objective, priority level, budget, launch status, and staff assigned
     * including troop count or aid items depending on instance
     */
    public String readReport(String path) {
        File file = new File(path);

        String id = "";
        String objective = "";
        String priorityLevel = "";
        double budget = 0.0;
        boolean launchStatus = false;
        List<String> assignedStaff = new ArrayList<>();
        Map<String, Integer> aidItems = new HashMap<>();
        int troopCount = 0;

        try (Scanner input = new Scanner(file)) {
            if (input.hasNextLine()) {
                String[] missionDetails = input.nextLine().split(",");
                id = missionDetails[0];
                objective = missionDetails[1];
                priorityLevel = missionDetails[2];
                budget = Double.parseDouble(missionDetails[3]);
                launchStatus = Boolean.parseBoolean(missionDetails[4]);
            }

            if (input.hasNextLine()) {
                String[] staffNames = input.nextLine().split(",");
                for (String name : staffNames) {
                    assignedStaff.add(name.trim());
                }
            }

            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains(",")) {
                    String[] aidItem = line.split(",");
                    String itemName = aidItem[0].trim();
                    int quantity = Integer.parseInt(aidItem[1].trim());
                    aidItems.put(itemName, quantity);
                } else {
                    troopCount = Integer.parseInt(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println(String.format("File %s does not exist", path));
        }

        return "aidItems=" + aidItems +
                ", troopCount=" + troopCount +
                ", id='" + id +
                "', objective='" + objective +
                "', priorityLevel=" + priorityLevel +
                ", budget=" + budget +
                ", launchStatus=" + launchStatus +
                ", assignedStaff=" + assignedStaff;
    }

    /**
     * writes a CSV mission report, including details such as
     * ID, objective, priority level, budget, launch status, staff assigned
     * including troop count or aid items depending on instance
     */
    public void generateReport(Mission mission) {
        File file = new File("src/main/resources/missions/" + mission.getId() + ".csv");

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(mission.getId() + ",");
            fw.write(mission.getObjective() + ",");
            fw.write(mission.getPriorityLevel() + ",");
            fw.write(mission.getBudget() + ",");
            fw.write(mission.getLaunchStatus() + "\n");

            if (!mission.getAssignedStaff().isEmpty()) {
                for (int i = 0; i < mission.getAssignedStaff().size(); i++) {
                    fw.write(mission.getAssignedStaff().get(i).getName());
                    if (i < mission.getAssignedStaff().size() - 1) {
                        fw.write(",");
                    }
                }
            }

            fw.write("\n");

            if (mission instanceof Humanitarian) {
                for (Map.Entry<String, Integer> aidItem : ((Humanitarian) mission).getAidItems().entrySet()) {
                    fw.write(aidItem.getKey() + "," + aidItem.getValue() + "\n");
                }
            }

            if (mission instanceof Peacekeeping) {
                fw.write(Integer.toString(((Peacekeeping) mission).getTroopCount()));
            }
        } catch (IOException e) {
            System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
        }
    }

    public abstract void displayDetails();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mission mission = (Mission) o;
        return Double.compare(budget, mission.budget) == 0 && launchStatus == mission.launchStatus && Objects.equals(id, mission.id) && Objects.equals(objective, mission.objective) && priorityLevel == mission.priorityLevel && Objects.equals(assignedStaff, mission.assignedStaff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objective, priorityLevel, budget, launchStatus, assignedStaff);
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id='" + id + '\'' +
                ", objective='" + objective + '\'' +
                ", priorityLevel=" + priorityLevel +
                ", budget=" + budget +
                ", launchStatus=" + launchStatus +
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

    public boolean getLaunchStatus() {
        return launchStatus;
    }

    public void setLaunchStatus(boolean launchStatus) {
        this.launchStatus = launchStatus;
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
