package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String studentID;
    private String courses;
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    //using static in this instance will allow the base ID to be 1000 and we can increment from there
    private static int id = 1000;

    //constructor promts user students's name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student's first name: ");
        this.firstName = in.nextLine();

        System.out.print("enter student's last name: ");
        this.lastName = in.nextLine();

        System.out.print("1-Freshmen\n2-Sophmore\n3-Junior\n4-Senior\n Enter student class level: ");
        this.gradeYear = in.nextLine();

        setStudentID();
        //System.out.println(firstName+" "+lastName+" year:"+gradeYear+" ID:"+ studentID);
    }
    //generate an ID
    private void setStudentID(){
        //Grade level + ID
        id++;
        this.studentID = gradeYear +""+id;
    }

    //enroll in courses
    public void enroll(){
        //set a loop, user keys in 0 to stop enrollment
        do {
        System.out.println("Enter course to enroll (Q to quit): ");
        Scanner in = new Scanner(System.in);
        String course = in.nextLine();
        if (!course.equals("Q")){
            courses = courses + "\n" + course;
            tuitionBalance = tuitionBalance + costOfCourse;
        }else {break;}
    }while (1 != 0);
       /* System.out.println("ENROLLED IN: "+courses);
        System.out.println("TUITION BALANCE: $"+tuitionBalance);*/
    }
    //view balance
    public void viewBalance(){
        System.out.println("Your balance is: $" +tuitionBalance);
    }
    //pay tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $"+payment);
        viewBalance();
    }
    //show status
    public String showInfo(){
        return "Name: "+firstName + " " +lastName+ "\nSTUDENT ID: "+studentID+"\nGRADE YEAR: "+gradeYear+"\nCOURSES ENROLLED: "+courses+"\nBALANCE DUE: $"+tuitionBalance;
    }
}