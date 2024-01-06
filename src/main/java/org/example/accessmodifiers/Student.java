package org.example.accessmodifiers;

public class Student {
    public String name;
    private int batchId;
    protected double psp;
    int age;

    void changeBatchId(int newBatchId) {
        name ="Abhinav";
        batchId = newBatchId;
        psp = 90.1;
        age=25;

    }

    public Student(String studentName,int studentBatchId, double studentPsp, int studentAge){

        name=studentName;
        batchId=studentBatchId;
        psp=studentPsp;
        age=studentAge;
    }

    public Student( Student student){
        //This is a public constructor that initializes the Student object
        // with the provided values for name, batchId, psp, and age.
        name=student.name;
        batchId=student.batchId;
        psp=student.psp;
        age=student.age;

    }

}
