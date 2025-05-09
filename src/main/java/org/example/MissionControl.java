package org.example;

import java.util.List;

public class MissionControl {
    private List<Mission> missions;

    public MissionControl(List<Mission> missions) {
        this.missions = missions;
    }

    /**
     * creates mission with following information
     * @param id given ID
     * @param objective given objective
     * @param priorityLevel given priority level
     * @param budget given budget
     * @return whether or not the mission could be added
     */
    public boolean addMission (String id, String objective, int priorityLevel, double budget) {
        if (findMissionById(id) != null) {
            System.out.println("Mission with identical ID already exists.");
            return false;
        }

        // TODO
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
    private Mission findMissionById(String missionId) {
        for (Mission mission : missions) {
            if (mission.getId().equals(missionId)) {
                return mission;
            }
        }
        return null;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
}
