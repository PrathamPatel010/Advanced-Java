public class Student {
    private long ID;
    private String name;
    private int sem;
    private String div;
    private String dept;
    private double sgpa;
    private double cgpa;

    public Student() {
        ID=0;
        name=div=dept=null;
        sgpa=cgpa=sem=0;
    }
    
    
    public Student(long enrollmentNo, String name, int sem, String div, String dept, double sgpa, double cgpa) {
        this.ID = enrollmentNo;
        this.name = name;
        this.sem = sem;
        this.div = div;
        this.dept = dept;
        this.sgpa = sgpa;
        this.cgpa = cgpa;
    }

    public long getID() {return ID;}

    public String getName() {return name;}

    public int getSem() {return sem;}

    public String getDiv() {return div;}

    public String getDept() {return dept;}

    public double getSgpa() {return sgpa;}

    public double getCgpa() {return cgpa;}

    public void setID(long enrollmentNo) {this.ID = enrollmentNo;}

    public void setName(String name) {this.name = name;}

    public void setSem(int sem) {this.sem = sem;}

    public void setDiv(String div) {this.div = div;}

    public void setDept(String dept) {this.dept = dept;}

    public void setSgpa(double sgpa) {this.sgpa = sgpa;}

    public void setCgpa(double cgpa) {this.cgpa = cgpa;}
}
