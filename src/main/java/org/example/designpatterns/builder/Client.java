package org.example.designpatterns.builder;

public class Client {
    public static void main(String[] args) {
        //Builder builder= new Builder();
        Builder builder=Student.getBuilder();

        builder.setName("Abhinav");
        builder.setAge(25);
        builder.setUnivName("HITK");
        builder.setGradYear(2020);

        //Student student=new Student(builder);
        Student student=builder.builder();

        System.out.println("Debug");

    }
}
