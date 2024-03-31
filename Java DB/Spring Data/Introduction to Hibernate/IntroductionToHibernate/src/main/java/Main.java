import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Your Code Here
        /*Student example = new Student();
        Student newStudent = new Student("Pesho");

        Student getStudent = session.get(Student.class, 3L);

        List<Student> studentList =
                session.createQuery("FROM Student WHERE name = 'Pesho'" ,
                        Student.class).list();
        for (Student student : studentList) {
            System.out.println(student.getId());
        }

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Student> r = criteria.from(Student.class);
        criteria.select(r).where(builder.like(r.get("name"),"P%"));
        List<Student> studentList =
                session.createQuery(criteria).getResultList();
        for (Student student : studentList) {
            System.out.println(student.getName());
        }*/

        session.getTransaction().commit();
        session.close();
    }
}
