package org.example;

import java.util.List;

public class MissionControl {
    public static List<Mission> missions;

    /**
     * creates mission
     * @param mission given mission
     * @return whether or not the mission could be added
     */
    public static boolean addMission (Mission mission) {
        if (mission == null) {
            System.out.println("Cannot add a null mission.");
            return false;
        }

        for (Mission existingMission : missions) {
            if (existingMission.getId().equals(mission.getId())) {
                System.out.println("A mission with this ID already exists.");
                return false;
            }
        }

        missions.add(mission);
        System.out.println("Mission with ID " + mission.getId() + " has been added.");
        return true;
    }

    /**
     * deletes mission
     * @param mission given mission
     * @return whether or not the mission could be terminated
     */
    public static boolean terminateMission(Mission mission) {
        for (Mission existingMission : missions) {
            if (existingMission.equals(mission)) {
                missions.remove(existingMission);
                System.out.println("Mission has been terminated.");

                return true;
            }
        }

        System.out.println("The mission to terminate does not exist.");
        return false;
    }

    /**
     * records a mission by generating a report through generateReport().
     * staff can no longer be added or removed
     * @param missionId id for mission to be recorded
     * @return whether or not the mission could be launched
     */
    public boolean launchMission(String missionId) {
        if (findMissionById(missionId) == null) {
            System.out.println("Mission could not be found.");
            return false;
        }

        Mission mission = findMissionById(missionId);

        if (mission.launchStatus) {
            System.out.println("Mission has already been launched.");
            return false;
        }

        mission.setLaunchStatus(true);
        mission.generateReport(mission);
        System.out.println("Mission " + missionId + " launched and report generated.");
        return true;
    }

    /**
     * finds mission based on its id
     * @param missionId given mission id
     * @return mission associated to id
     */
    public Mission findMissionById(String missionId) {
        return missions.stream()
                .filter(mission -> mission.getId().equals(missionId))
                .findFirst() // i had to teach myself this
                .orElse(null);
    }

    public static List<Mission> getMissions() {
        return missions;
    }

    public static void setMissions(List<Mission> missions) {
        MissionControl.missions = missions;
    }
}
