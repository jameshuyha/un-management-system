import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MissionTest {
    @Test
    public void testAddStaff_successfullyAdded() {
        Mission mission = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);
        Staff staff1 = new Administrator("James Ha", "Vietnam", Staff.SecurityLevel.ONE, "Software Engineering");

        Assertions.assertTrue(mission.addStaff(staff1));
        Assertions.assertTrue(mission.getAssignedStaff().contains(staff1));
    }

    @Test
    public void testAddStaff_staffMemberAlreadyInMission() {
        Mission mission = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);
        Staff staff1 = new Administrator("James Ha", "Vietnam", Staff.SecurityLevel.ONE, "Software Engineering");

        mission.addStaff(staff1);
        Assertions.assertFalse(mission.addStaff(staff1));
    }

    @Test
    public void testRemoveStaff_successfullyRemoved() {
        Mission mission = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);
        Staff staff1 = new Administrator("James Ha", "Vietnam", Staff.SecurityLevel.ONE, "Software Engineering");

        mission.addStaff(staff1);

        Assertions.assertTrue(mission.removeStaff(staff1));
        Assertions.assertFalse(mission.getAssignedStaff().contains(staff1));
    }

    @Test
    public void testRemoveStaff_staffMemberNotInMission() {
        Mission mission = new Peacekeeping("1", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);
        Staff staff1 = new Administrator("James Ha", "Vietnam", Staff.SecurityLevel.ONE, "Software Engineering");

        Assertions.assertFalse(mission.removeStaff(staff1));
    }

    @Test
    public void testReadReport() {
        Mission mission = new Peacekeeping("111", "Protect Children in Tigray", Mission.PriorityLevel.THREE, 2000.0, false, new ArrayList<>(), 678);
        Staff staff1 = new Administrator("James Ha", "Vietnam", Staff.SecurityLevel.ONE, "Software Engineering");
        Staff staff2 = new Diplomat("Edric Tran", "China", Staff.SecurityLevel.THREE, "Canada");

        mission.addStaff(staff1);
        mission.addStaff(staff2);

        mission.generateReport(mission);

        String expected = "aidItems={}, troopCount=678, id='111', objective='Protect Children in Tigray', priorityLevel=THREE, budget=2000.0, launchStatus=false, assignedStaff=[James Ha, Edric Tran]";
        String result = mission.readReport("src/main/resources/missions/111.csv");

        Assertions.assertEquals(expected, result);
    }
}
