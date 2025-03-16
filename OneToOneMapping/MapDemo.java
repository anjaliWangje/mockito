package OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Question q1= new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("what is java");

        Answer answer=new Answer();
        answer.setAnswerId(243);
        answer.setAnswer("java is programming langauge");

        Session s=factory.openSession();
        Transaction txt=s.beginTransaction();

        s.save(q1);
        s.save(answer);
        txt.commit();
        s.close();







        factory.close();
    }
}
