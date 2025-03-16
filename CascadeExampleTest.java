package org.example;

import static org.mockito.Mockito.*;
import OneToManymapping.College;
import OneToManymapping.Departmentt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.HashSet;
import java.util.Set;

    public class CascadeExampleTest {
// @Mock=Create a mock object
        @Mock
        private Session mockSession;

        @Mock
        private SessionFactory mockSessionFactory;

        @Mock
        private Transaction mockTransaction;

        private Departmentt department;

        private College college1;
        private College college2;
        private College college3;

        @BeforeEach
        public void setUp() {

            MockitoAnnotations.openMocks(this);

            department = new Departmentt();
            department.setDepartentId(123);
            department.setDepartmentName("IT");

            college1 = new College("M.S. Bidve", 1223);
            college2 = new College("J.S.P.M", 1224);
            college3 = new College("D.Y.P", 1225);

            Set<College> collegeSet = new HashSet<>();
            collegeSet.add(college1);
            collegeSet.add(college2);
            collegeSet.add(college3);
            department.setColleges(collegeSet);
        }

        @Test
        public void testCascadeSaveDepartmentAndColleges() {
// when=specifies the behaviour of a mock method
            when(mockSession.getTransaction()).thenReturn(mockTransaction);
            when(mockSessionFactory.openSession()).thenReturn(mockSession);

            mockSession.beginTransaction();
            mockSession.save(department);
            mockSession.save(college1);
            mockSession.save(college2);
            mockSession.save(college3);
            mockSession.getTransaction().commit();
// verify=verify that a mock method was called
            verify(mockSession, times(1)).save(department);
            verify(mockSession, times(1)).save(college1);
            verify(mockSession, times(1)).save(college2);
            verify(mockSession, times(1)).save(college3);

            verify(mockSession, times(1)).beginTransaction();
            verify(mockTransaction, times(1)).commit();
        }

        @Test
        public void testTransactionHandling() {
 // thenreturn=specify the return value of a mock method
            when(mockSession.getTransaction()).thenReturn(mockTransaction);
            when(mockSessionFactory.openSession()).thenReturn(mockSession);

            mockSession.beginTransaction();
            mockSession.save(department);
            mockSession.save(college1);
            mockSession.save(college2);
            mockSession.save(college3);
            mockSession.getTransaction().commit();

            verify(mockSession, times(1)).beginTransaction();
            verify(mockTransaction, times(1)).commit();
        }
    }

