package Cascade;

import OneToManymapping.College;
import OneToManymapping.Departmentt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CascadeExample {

    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session s=factory.openSession();
         Departmentt d1= new Departmentt();
         d1.setDepartmentName("it");
         d1.setDepartentId(123);

         College c1=new College("m.s.bidve",1223);
        College c2=new College("j.s.p.m",1224);
        College c3=new College("d.y.p",1225);
        Set<College> list=new HashSet<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        d1.setColleges(list);
        Transaction txt= s.beginTransaction();

     s.save(d1);
     s.save(c1);
        s.save(c2);
        s.save(c3);
     txt.commit();









        s.close();
        factory.close();
    }

}
