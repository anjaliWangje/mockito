package org.example;


    import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

    import OneToManymapping.College;
    import OneToManymapping.Departmentt;
    import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.HashSet;
import java.util.Set;

    public class DepartmenttTest {

        private EntityManager entityManager;
        private Departmentt department;
        private College college1;
        private College college2;

        @BeforeEach
        public void setup() {
            entityManager = mock(EntityManager.class);
            department = new Departmentt();
            department.setDepartentId(123);
            department.setDepartmentName("Civil Department");

            college1 = new College();
            college1.setCollegecode(101);
            college1.setCollegeName("M.S. Bidve College");

            college2 = new College();
            college2.setCollegecode(102);
            college2.setCollegeName("Sandipani Technical Latur");

            college1.setDepartment(department);
            college2.setDepartment(department);

            Set<College> colleges = new HashSet<>();
            colleges.add(college1);
            colleges.add(college2);
            department.setColleges(colleges);
        }

        @Test
        public void testDepartmentColleges() {
            when(entityManager.find(Departmentt.class, 123)).thenReturn(department);

            Departmentt retrievedDepartment = entityManager.find(Departmentt.class, 123);

            assertNotNull(retrievedDepartment);
            assertEquals(123, retrievedDepartment.getDepartentId());
            assertEquals(2, retrievedDepartment.getColleges().size());
        }

        @Test
        public void testGetDepartmentName() {
            assertEquals("Civil Department", department.getDepartmentName());
        }

        @Test
        public void testAddCollegeToDepartment() {
            College college3 = new College();
            college3.setCollegecode(103);
            college3.setCollegeName("ABC College");
            college3.setDepartment(department);

            Set<College> updatedColleges = department.getColleges();
            updatedColleges.add(college3);
            department.setColleges(updatedColleges);

            assertEquals(3, department.getColleges().size());
        }
    }


