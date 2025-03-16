package org.example;


import OneToManymapping.College;
import OneToManymapping.Departmentt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class CollegeTest {
// assertEqual= verify expected result,ensure correction,catch bugs
        private College college;
        private Departmentt department;

        @BeforeEach
        public void setup() {

            department = new Departmentt();
            department.setDepartentId(123);
            department.setDepartmentName("Mechanical Engineering");

            college = new College();
            college.setCollegeName("Engineering College");
            college.setDepartment(department);
        }

        @Test
        public void testCollegeDetails() {


            assertEquals("Mechanical Engineering", college.getDepartment().getDepartmentName());
        }

        @Test
        public void testSetDepartmentForCollege() {
            Departmentt newDepartment = new Departmentt();
            newDepartment.setDepartentId(124);
            newDepartment.setDepartmentName("Electrical Engineering");

            college.setDepartment(newDepartment);
            assertEquals("Electrical Engineering", college.getDepartment().getDepartmentName());
        }
    }


