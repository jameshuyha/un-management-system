import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.MissionControl;

import java.util.ArrayList;
import java.util.HashMap;

public class MissionControlTest {

    @Test
    public void testAddMission_normalMission() {
        MissionControl.missions = new ArrayList<>();
        Mission mission = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);

        Assertions.assertTrue(new MissionControl().addMission(mission));
        Assertions.assertTrue(MissionControl.missions.contains(mission));
    }

    @Test
    public void testAddMission_nullMission() {
        MissionControl.missions = new ArrayList<>();
        Assertions.assertFalse(new MissionControl().addMission(null));
    }

    @Test
    public void testAddMission_duplicateMissionIds() {
        MissionControl.missions = new ArrayList<>();

        Mission mission1 = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);
        Mission mission2 = new Humanitarian("1", "Transport Aid to Victims of the Myanmar Earthquake", Mission.PriorityLevel.FOUR, 25000.0, false, new ArrayList<>(), new HashMap<>());

        Assertions.assertTrue(new MissionControl().addMission(mission1));
        Assertions.assertFalse(new MissionControl().addMission(mission2));
        Assertions.assertTrue(MissionControl.missions.contains(mission1));
        Assertions.assertFalse(MissionControl.missions.contains(mission2));
    }

    @Test
    public void testAddMission_twoNormalMissions() {
        MissionControl.missions = new ArrayList<>();
        Mission mission1 = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);
        Mission mission2 = new Humanitarian("2", "Transport Aid to Victims of the Myanmar Earthquake", Mission.PriorityLevel.FOUR, 25000.0, false, new ArrayList<>(), new HashMap<>());

        Assertions.assertTrue(new MissionControl().addMission(mission1));
        Assertions.assertTrue(new MissionControl().addMission(mission2));
        Assertions.assertTrue(MissionControl.missions.contains(mission1));
        Assertions.assertTrue(MissionControl.missions.contains(mission2));
    }

    @Test
    public void testTerminateMission_successful() {
        MissionControl.missions = new ArrayList<>();
        Mission mission = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);

        MissionControl.missions.add(mission);

        Assertions.assertTrue(new MissionControl().terminateMission(mission));
        Assertions.assertFalse(MissionControl.missions.contains(mission));
    }

    @Test
    public void testTerminateMission_terminatingWrongMission() {
        MissionControl.missions = new ArrayList<>();

        Mission mission1 = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);
        Mission mission2 = new Humanitarian("2", "Transport Aid to Victims of the Myanmar Earthquake", Mission.PriorityLevel.FOUR, 25000.0, false, new ArrayList<>(), new HashMap<>());

        MissionControl.missions.add(mission1);

        Assertions.assertFalse(new MissionControl().terminateMission(mission2));
        Assertions.assertTrue(MissionControl.missions.contains(mission1));
    }

    @Test
    public void testTerminateMission_emptyList() {
        MissionControl.missions = new ArrayList<>();
        Mission mission = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);

        Assertions.assertFalse(new MissionControl().terminateMission(mission));
        Assertions.assertFalse(MissionControl.missions.contains(mission));
    }

    @Test
    public void testTerminateMission_terminateMultipleMissions() {
        MissionControl.missions = new ArrayList<>();

        Mission mission1 = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);
        Mission mission2 = new Humanitarian("2", "Transport Aid to Victims of the Myanmar Earthquake", Mission.PriorityLevel.FOUR, 25000.0, false, new ArrayList<>(), new HashMap<>());

        MissionControl.missions.add(mission1);
        MissionControl.missions.add(mission2);

        Assertions.assertTrue(new MissionControl().terminateMission(mission1));
        Assertions.assertTrue(new MissionControl().terminateMission(mission2));
        Assertions.assertFalse(MissionControl.missions.contains(mission1));
        Assertions.assertFalse(MissionControl.missions.contains(mission2));
    }

    @Test
    public void testLaunchMission_successful() {
        MissionControl.missions = new ArrayList<>();
        Mission mission = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);

        MissionControl.missions.add(mission);

        Assertions.assertTrue(new MissionControl().launchMission("1"));
        Assertions.assertTrue(mission.getLaunchStatus());
    }

    @Test
    public void testLaunchMission_noMissionsToLaunch() {
        MissionControl.missions = new ArrayList<>();
        Assertions.assertFalse(new MissionControl().launchMission("1"));
    }

    @Test
    public void testFindMissionById_successful() {
        MissionControl.missions = new ArrayList<>();

        Mission mission1 = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);
        Mission mission2 = new Humanitarian("2", "Transport Aid to Victims of the Myanmar Earthquake", Mission.PriorityLevel.FOUR, 25000.0, false, new ArrayList<>(), new HashMap<>());

        MissionControl.missions.add(mission1);
        MissionControl.missions.add(mission2);

        Assertions.assertEquals(mission1, new MissionControl().findMissionById("1"));
    }
}
