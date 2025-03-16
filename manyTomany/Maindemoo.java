package manyTomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Maindemoo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        emp e1 = new emp();
        emp e2 = new emp();
        e1.setEid(34);
        e1.setName("anjali");
        e2.setEid(35);
        e2.setName("pranali");
        Project p1 = new Project();
        Project p2 = new Project();
        p1.setPid(1212);
        p1.setProjectname("Libarry mangement");
        p1.setPid(1213);
        p1.setProjectname("curd operation");
        List<emp> list1 = new ArrayList<>();
        List<Project> list2 = new ArrayList<>();
        list1.add(e1);
        list1.add(e2);
        list2.add(p1);
        list2.add(p2);

        e1.setProjects(list2);
        p2.setEmps(list1);
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        s.save(e1);
        s.save(e2);
        s.save(p1);
        s.save(p2);

        tx.commit();

        factory.close();
    }
}
