package edu.hackerrank.datastructures;

import java.util.*;

public class MyPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<pStudent> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (pStudent st: students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Priorities {
    private static Comparator<pStudent> studentComparator = new Comparator<pStudent>() {
        @Override
        public int compare(pStudent o1, pStudent o2) {
            if(o1.getCGPA() != o2.getCGPA())
                return (o1.getCGPA() < o2.getCGPA()) ? 1 : -1;
            if(o1.getName().compareTo(o2.getName()) != 0)
                return o1.getName().compareTo(o2.getName());
            return (o1.getID() < o2.getID()) ? 1 : -1;
        }
    };

    public List<pStudent> getStudents(List<String> events){
        PriorityQueue<pStudent> pQueue = new PriorityQueue<>(events.size(),studentComparator);

        for(String event: events){
            String[] params = event.split(" ");
            if(params.length > 1){
                // ENTER
                pQueue.add(new pStudent(Integer.parseInt(params[3]), params[1], Double.parseDouble(params[2])));
            }else{
                // SERVE
                pQueue.poll();
            }
        }

        List<pStudent> remaining = new ArrayList<>();
        pStudent aStudent;

        while((aStudent = pQueue.poll()) != null){
            remaining.add(aStudent);
        }

        return remaining;
    }
}

class pStudent{
    private int id;
    private String name;
    private double cgpa;

    public pStudent(int id,String name,double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getCGPA(){
        return this.cgpa;
    }

    @Override
    public String toString(){
        return "(" + getName() + "," + Double.toString(getCGPA()) + "," + Integer.toString(getID()) + ")";
    }
}