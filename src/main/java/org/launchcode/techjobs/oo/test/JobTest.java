package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
       Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1.getId(), testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job testJob1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertNotEquals(testJob1.getId(), testJob2.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        //create a job object with non-empty values in the fields
        //call toString on object and store return in a variable
        //build up an excepted string
        //compare with assertEquals
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals(testJob.toString(), "\n"+" "+"\n");


//        assertEquals(testJob.getId(), "ID: _______Product tester_______\n");
//        assertEquals(testJob.getName().toString(), "Name: _______Product tester_______\n");
//        assertEquals(testJob.getEmployer().getValue().toString(), "Employer: _______Product tester_______\n");
//        assertEquals(testJob.getLocation().getValue().toString(), "Location: _______Product tester_______\n");
//        assertEquals(testJob.getPositionType().getValue().toString(), "Position: _______Product tester_______\n");
//        assertEquals(testJob.getCoreCompetency().getValue().toString(), "Core Competency: _______Product tester_______");
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals(testJob.toString(),
                "\n"+"ID: "+ testJob.getId()+"\n"+
                "\n"+"Name: "+ testJob.getName() +"\n"+
                "\n"+"Employer: "+ testJob.getEmployer().getValue() +"\n"+
                "\n"+"Location: "+testJob.getLocation().getValue()+"\n"+
                "\n"+"Position Type: "+ testJob.getPositionType().getValue() +"\n"+
                "\n"+"Core Competency: "+testJob.getCoreCompetency().getValue()+"\n");
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob = new Job("",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));
        assertEquals(testJob.toString(),
                "\n"+"ID: "+ testJob.getId()+"\n"+
                        "\n"+"Name: "+"Data not available"+"\n"+
                        "\n"+"Employer: "+ "Data not available" +"\n"+
                        "\n"+"Location: "+"Data not available"+"\n"+
                        "\n"+"Position Type: "+ "Data not available" +"\n"+
                        "\n"+"Core Competency: "+"Data not available"+"\n");
    }
}
