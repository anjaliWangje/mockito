package OneToManymapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class maindemo {


    public static void main(String[] args) {

                SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Departmentt.class)
                        .addAnnotatedClass(College.class)
                        .buildSessionFactory();

        Session session=factory.openSession();

                Departmentt department = new Departmentt();
                department.setDepartentId(123);

               department.setDepartmentName("civil department");

               //College college1 = new College();
               //college1.setCollegecode(123);
               // college1.setCollegeName("m.s.bidve clg");

              //  College college2 = new College();
              //  college2.setCollegeName("sandipani technical latur");

              //  college1.setDepartment(department);
              ///  college2.setDepartment(department);

               // Set<College> colleges = new HashSet<>();
               // colleges.add(college1);
               // colleges.add(college2);
               // department.setColleges(colleges);

                    Transaction txt=  session.beginTransaction();
                    Departmentt d=(Departmentt) session.get(Departmentt.class,123);
        System.out.println(d.getDepartentId());
        System.out.println(d.getDepartmentName());
        System.out.println(d.getColleges().size());


               // session.save(department);

                txt.commit();
                System.out.println("Department and colleges saved successfully!");

                factory.close();
            }
        }



