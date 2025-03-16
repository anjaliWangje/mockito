package org.example;

import static org.mockito.Mockito.*;
import OneToOneMapping.Answer;
import OneToOneMapping.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mockito.Mock;

public class MapDemoTest {
        @Mock
        private Session mockSession;
        @Mock
        private Transaction mockTransaction;
        private Question mockQuestion;
        private Answer mockAnswer;

        @BeforeEach
        public void setUp() {
            mockSession = mock(Session.class);
            mockTransaction = mock(Transaction.class);

            mockQuestion = mock(Question.class);
            mockAnswer = mock(Answer.class);
        }

        @Test
        public void testSaveQuestionAndAnswer() {

            when(mockSession.beginTransaction()).thenReturn(mockTransaction);


            when(mockQuestion.getQuestionId()).thenReturn(1212);
            when(mockQuestion.getQuestion()).thenReturn("What is Java?");
            when(mockAnswer.getAnswerId()).thenReturn(243);
            when(mockAnswer.getAnswer()).thenReturn("Java is a programming language.");

            mockSession.save(mockQuestion);
            mockSession.save(mockAnswer);

            verify(mockSession, times(1)).save(mockQuestion);
            verify(mockSession, times(1)).save(mockAnswer);

            mockTransaction.commit();

            verify(mockTransaction, times(1)).commit();
        }
    }

