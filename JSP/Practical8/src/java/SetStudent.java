import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Utils.Student;

public class SetStudent extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        String rollNo = req.getParameter("rollNo");
        Student student = (Student)req.getSession().getAttribute("student");
        if(student==null){
            student = new Student();
        }
        
        if(rollNo!=null && !rollNo.isEmpty()){
            int rollNum = Integer.parseInt(rollNo);
            student.setRollNo(rollNum);
        }
        req.setAttribute("student", student);
        req.getRequestDispatcher("student.jsp").forward(req, res);
    }
}
