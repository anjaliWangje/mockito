package org.example;



import manyTomany.Project;
import manyTomany.emp;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;

    public class MaindemooTest {
      @Mock
        private Session mockSession;
      @Mock
        private Transaction mockTransaction;
        private emp mockEmp1;
        private emp mockEmp2;
        private Project mockProject1;
        private Project mockProject2;

        @BeforeEach
        public void setUp() {
            mockSession = mock(Session.class);
            mockTransaction = mock(Transaction.class);

            mockEmp1 = mock(emp.class);
            mockEmp2 = mock(emp.class);
            mockProject1 = mock(Project.class);
            mockProject2 = mock(Project.class);
        }

        @Test
        public void testSaveManyToMany() {
            when(mockEmp1.getEid()).thenReturn(34);
            when(mockEmp1.getName()).thenReturn("Anjali");
            when(mockEmp2.getEid()).thenReturn(35);
            when(mockEmp2.getName()).thenReturn("Pranali");

            when(mockProject1.getPid()).thenReturn(1212);
            when(mockProject1.getProjectname()).thenReturn("Library Management");
            when(mockProject2.getPid()).thenReturn(1213);
            when(mockProject2.getProjectname()).thenReturn("CRUD Operations");

            List<emp> empList = new ArrayList<>();
            List<Project> projectList = new ArrayList<>();
            empList.add(mockEmp1);
            empList.add(mockEmp2);
            projectList.add(mockProject1);
            projectList.add(mockProject2);


            when(mockEmp1.getProjects()).thenReturn(projectList);
            when(mockEmp2.getProjects()).thenReturn(projectList);
            when(mockProject1.getEmps()).thenReturn(empList);
            when(mockProject2.getEmps()).thenReturn(empList);

            mockSession.save(mockEmp1);
            mockSession.save(mockEmp2);
            mockSession.save(mockProject1);
            mockSession.save(mockProject2);

            verify(mockSession, times(1)).save(mockEmp1);
            verify(mockSession, times(1)).save(mockEmp2);
            verify(mockSession, times(1)).save(mockProject1);
            verify(mockSession, times(1)).save(mockProject2);

            mockTransaction.commit();

            verify(mockTransaction, times(1)).commit();


        }
    }
