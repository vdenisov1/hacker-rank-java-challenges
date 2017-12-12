package edu.hackerrank.datastructures;

import java.util.*;

//Complete the code
public class MySort{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList);

        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}

class Student implements Comparable<Student>{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }

    public int compareTo(Student other){

        if(this.getCgpa() > other.getCgpa())
            return -1;
        if(this.getCgpa() < other.getCgpa())
            return 1;
        if(this.getFname().compareTo(other.getFname()) != 0)
            return this.getFname().compareTo(other.getFname());
        if(this.getId() > other.getId())
            return -1;
        if(this.getId() < other.getId())
            return 1;

        return 0;
    }
}