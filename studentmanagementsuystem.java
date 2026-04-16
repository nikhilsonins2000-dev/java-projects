import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
class Student{
    private int id ;
    private String name;
    private double marks;

    public Student(int id, String name, double marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getMarks(){
        return marks;
    }

    public void SetMarks(double marks)
    {
        this.marks=marks;
    }
}
public class studentmanagementsuystem {
    public static void main(String[] args) {
        Student s1;
        Scanner sc = new Scanner(System.in);
        ArrayList<Student>Students=new ArrayList<>();
        Boolean running =true;
        while (running){
            System.out.println("=====MENU=====");
            System.out.println("1. Add Student");
            System.out.println("2.Add marks");
            System.out.println("3.Show students by id");
            System.out.println("4. edit marks");
            System.out.println("5.delete student ");
            System.out.println("6. to exit");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Student ID:");
                    int id=sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Student Name:");
                    String name=sc.nextLine();

                    Students.add(new Student(id,name,0));
                    System.out.println("student added successfully");
                    break;

                case 2:
                    System.out.println("enter student id:");
                    int searchid=sc.nextInt();
                    sc.nextLine();
                    boolean found=false;
                    for(Student s: Students) {
                        if(s.getId()==searchid) {
                            System.out.println("Enter Student marks:");
                            double marks = sc.nextDouble();
                            s.SetMarks(marks);
                            found = true;
                            System.out.println("marks added successfully");
                        }

                    }
                    if(!found) {
                        System.out.println("student not found");
                    }
                    break;
                case 3:
                    System.out.println("enter student id:");
                    int findid=sc.nextInt();
                    sc.nextLine();
                    int found1=0;
                    for (Student s: Students) {
                        if(s.getId()==findid) {
                            System.out.println("student id : "+s.getId());
                            System.out.println("student name : "+s.getName());
                            System.out.println("student marks : "+s.getMarks());
                            found1=1;
                        }


                    }
                    if(found1==0) {
                        System.out.println("student not found");
                    }
                    break;
                case 4:
                    System.out.println("enter student id:");
                    int modifyid=sc.nextInt();
                    sc.nextLine();
                    for (Student s: Students) {
                        if(s.getId()==modifyid) {
                            System.out.println("enter modified marks:");
                            double modified_marks = sc.nextDouble();
                            s.SetMarks(modified_marks);
                        }
                    }
                    break;

                case 5:
                    System.out.println("enter student id:");
                    int deleteid=sc.nextInt();
                    sc.nextLine();
//
                    boolean found2 = false;

                    for(int i = 0; i < Students.size(); i++) {
                        if(Students.get(i).getId() == deleteid) {
                            System.out.println("student id : " + Students.get(i).getId());
                            Students.remove(i);
                            System.out.println("is deleted successfully");
                            found2 = true;
                            break;
                        }
                    }

                    if(!found2) {
                        System.out.println("student not found");
                    }
                    System.out.println("remaining students :"+Students.size());
                    break;
                case 6:
                    System.out.println("exiting the system.....");
                    running=false;
                    break;

                    default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        sc.close();
    }
}
