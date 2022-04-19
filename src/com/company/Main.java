package com.company;

import java.util.Scanner;

//information we have-first 3 sems gpa, java CT marks
//there are 5 subjects with 3 credits each and 1 subject with 4 credits
//there are 3 labs with 1.5 credits each
//maths and oops have 2 parts
//final exam marks is assumed to be as 100 and overall calculation shall be 100*0.7+30
//we need a class as subject which has the field of credit
//we need subclass for normal subjects with 3 credits each and another for the one with 4 credits
//in our manager we store the credits of 9 subjects along with a field for total credits
public class Main {

    public static void main(String[] args) {
        // write your code here
        Manager endsem=new Manager();
        Scanner sc=new Scanner(System.in);
        double sem1,sem2,sem3;
        System.out.println("Enter your 1st sem gpa");
        sem1=Integer.parseInt(sc.nextLine());
        System.out.println("Enter your 2nd sem gpa");
        sem2=Integer.parseInt(sc.nextLine());
        System.out.println("Enter your 3rd sem gpa");
        sem3=Integer.parseInt(sc.nextLine());
        System.out.println("Enter marks for this semester");
        System.out.println("Enter expected marks for semester exam out of 100");
        int temp;
        int temp2;
        int temp3;
        for(int i=0;i<5;i++){
            System.out.println("Enter marks for "+endsem.subjects[i].name);
            temp=Integer.parseInt(sc.nextLine());
            endsem.subjects[i].marks_semester=temp;
        }
        System.out.println("Enter marks in Maths");
        temp=Integer.parseInt(sc.nextLine());
        endsem.maths.marks_semester=temp;
        System.out.println("Enter marks in class test(out of 30)");
        for(int i=0;i<4;i++){
            System.out.println("Enter marks for "+endsem.subjects[i].name);
            temp=Integer.parseInt(sc.nextLine());
            endsem.subjects[i].marks_classtest=temp;
        }
        System.out.println("Enter marks in AOOPS Java exam out of 15");
        temp=Integer.parseInt(sc.nextLine());
        System.out.println("Enter expected marks in AOOPS Python exam out of 30");
        temp2=Integer.parseInt(sc.nextLine());
        endsem.subjects[4].marks_classtest=temp+temp2/2;
        System.out.println("Enter marks in first Maths exam out of 30");
        temp=Integer.parseInt(sc.nextLine());
        System.out.println("Enter expected marks in second Maths exam out of 30");
        temp2=Integer.parseInt(sc.nextLine());
        endsem.maths.marks_classtest=(temp+temp2)/2;

        System.out.println("Enter marks in lab subjects");
        for(int i=0;i<3;i++){
            System.out.println("Enter marks for "+endsem.lsubjects[i].name);
            System.out.print("Attendance: ");
            temp=Integer.parseInt(sc.nextLine());
            System.out.print("Assignment: ");
            temp2=Integer.parseInt(sc.nextLine());
            System.out.print("Viva: ");
            temp3=Integer.parseInt(sc.nextLine());
            endsem.lsubjects[i].marks_total=temp+temp2+temp3;
        }
        endsem.calculate_total_marks();
        endsem.display_totals_marks();
        double gpa=endsem.calculate_gpa();
        System.out.println("The gpa for sem 4 is" +gpa);
        System.out.println("The gpa for first 2 years is" +(gpa+sem1+sem2+sem3)/4.0);
    }


}
class Subject{
    int marks_semester;
    int marks_classtest;
    int marks_total;
    String name;


    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }
}
class MathsSubject extends Subject{
}
class LabSubject{
    int marks_total;
    String name;
    public LabSubject(String name) {
        this.name = name;
    }
}
final class Manager{
    public Subject subjects[]=new Subject[5];
    MathsSubject maths=new MathsSubject();
    LabSubject lsubjects[]=new LabSubject[3];
    char GradeList[]=new char[9];
    Manager(){
        subjects[0]=new Subject("Graph Theory");
        subjects[1]=new Subject("Data Communication");
        subjects[2]=new Subject("Computer Architecture");
        subjects[3]=new Subject("Microprocessor & Assembly");
        subjects[4]=new Subject("AOOPS");
        lsubjects[0]=new LabSubject("Hardware Lab");
        lsubjects[1]=new LabSubject("AOOPS Lab");
        lsubjects[2]=new LabSubject("Microprocessor Lab");
    }
    void calculate_total_marks(){
        for (int i=0;i<5;i++){
            subjects[i].marks_total= (int)(subjects[i].marks_semester*0.7)+ subjects[i].marks_classtest;
        }
        maths.marks_total=(int)(maths.marks_semester*0.7)+maths.marks_classtest;
    }
    void display_totals_marks(){
        for (int i=0;i<5;i++){
            System.out.println("The total marks in "+subjects[i].name + "is "+ subjects[i].marks_total);
        }

        System.out.println("The total marks in Maths is "+ maths.marks_total);
        System.out.println("For lab subjects");
        for (int i=0;i<3;i++){
            System.out.println("The total marks in "+lsubjects[i].name + "is "+ lsubjects[i].marks_total);
        }
    }
    double calculate_gpa(){
        double gpa=0;
        for(int i=0;i<5;i++) {
            GradeList[i]=getGrade(subjects[i].marks_total);
        }
        GradeList[5]=getGrade(maths.marks_total);
        for(int i=6;i<9;i++){
            GradeList[i]=getGrade(lsubjects[i-6].marks_total);
        }
//        for(int i=0;i<5;i++){
//            if(subjects[i].marks_total>90){
//                GradeList[i]='S';
//                total_theory+=10;
//            }
//            else if(subjects[i].marks_total>80){
//                GradeList[i]='A';
//                total_theory+=9;
//
//            }
//            else if(subjects[i].marks_total>70){
//                GradeList[i]='B';
//                total_theory+=8;
//
//            }
//            else if(subjects[i].marks_total>60){
//                GradeList[i]='C';
//                total_theory+=7;
//
//            }
//            else if(subjects[i].marks_total>50){
//                GradeList[i]='D';
//                total_theory+=6;
//
//            }
//            else{
//                GradeList[i]='E';
//                total_theory+=5;
//            }
//        }
//
//        for(int i=6;i<9;i++){
//            if(lsubjects[i].marks_total>90){
//                GradeList[i]='S';
//                total_theory+=10;
//            }
//            else if(lsubjects[i].marks_total>80){
//                GradeList[i]='A';
//                total_theory+=9;
//
//            }
//            else if(lsubjects[i].marks_total>70){
//                GradeList[i]='B';
//                total_theory+=8;
//
//            }
//            else if(lsubjects[i].marks_total>60){
//                GradeList[i]='C';
//                total_theory+=7;
//
//            }
//            else if(lsubjects[i].marks_total>50){
//                GradeList[i]='D';
//                total_theory+=6;
//
//            }
//            else{
//                GradeList[i]='E';
//                total_theory+=5;
//            }
//        }
        for(int i=0;i<5;i++){
            gpa=gpa+(getScore(GradeList[i]))*3.0/10;
        }
        gpa=gpa+(getScore(GradeList[5]))*4.0/10;
        for(int i=6;i<9;i++){
            gpa=gpa+(getScore(GradeList[i]))*1.5/10;
        }
        return gpa*10/23.5;
    }
    char getGrade(int marks){
        if(marks>90){
            return 'S';
        }
        else if(marks>80){
            return 'A';
        }
        else if(marks>70){
            return 'B';
        }
        else if(marks>60){
            return 'C';

        }
        else if(marks>50){
            return 'D';
        }
        else{
            return 'E';
        }
    }
    int getScore(char grade){
        int score=0;
        switch (grade){
            case 'S':
                score=10;
                break;
            case 'A':
                score=9;
                break;
            case 'B':
                score=8;
                break;
            case 'C':
                score=7;
                break;
            case 'D':
                score=6;
                break;
            case 'E':
                score=5;
                break;

        }
        return score;
    }
}

