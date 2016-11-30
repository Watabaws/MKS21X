public class Student{
    private String firstName, lastName;
    private int osis, age;
    private double gpa;

    public Student(String first, String last, int ID, int years){
        firstName = first;
        lastName = last;
        osis = ID;
        age = years;
        gpa = 100.0;
    }

    public void printStudent(){
        System.out.println(this);
    }

    public void raiseGPA(int inc){
        gpa += inc;
        if(gpa > 100){
            gpa = 100;
        }
    }

    public void lowerGPA(int inc){
        gpa -= inc;
        if(gpa < 100){
            gpa = 0;
        }
    }
    public String toString(){
         return lastName+", "+firstName+"\nID: "+osis+"\tage: "+age+"\nGPA: "+gpa ;
    }
}
