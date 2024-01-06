package org.example.accessmodifiers;

public class Main {
    public static void main(String[] args) {

       /* Student student = new Student(); // default
        student.name = "Akash";
        student.age = 27;
        student.batchId = 10; //-> ERROR : private field.
        student.psp = 90.0; */

        //Student student1 = new Student();

        Student student=new Student("Stark",11,90.1,25);
        Student student1=new Student("Hulk",12,91.1,25);

        Student studentCopy = new Student(student); // copy constructor.

        Student student2 = student1; // Not even a copy.

        System.out.println("Debug");
    }
}
