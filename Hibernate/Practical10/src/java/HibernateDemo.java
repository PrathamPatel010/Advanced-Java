import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {
    public static void main(String[] args) {
        Session session = null;
        try{
            SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
            session = sessionfactory.openSession();
            session.beginTransaction();
            System.out.println("Adding New Student");
            Student student = new Student();
            student.setName("Pratham");
            student.setID(140);
            student.setSem(5);
            student.setDept("CE");
            student.setDiv("2");
            student.setSgpa(9.65);
            student.setCgpa(9.12);
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Student added successfully");
        } catch(Exception e){
            System.out.println(e.getCause());
            System.out.println("Error: " + e.getMessage());
        }
    }
}
