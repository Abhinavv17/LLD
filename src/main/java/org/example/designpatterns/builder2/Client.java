package org.example.designpatterns.builder2;


public class Client {

    public static void main(String[] args) {
        //Builder builder = new Builder();

//        Builder builder = Student.getBuilder();
//        builder.setName("Abhinav");
//        builder.setAge(25);
//        builder.setBatch("CSE");
//        builder.setGradYear(2020);
//
//        //Student student = new Student(builder);
//        Student student = builder.build();
//        System.out.println("DEBUG");

//        Student student1 = new Student(builder)

        Student student = Student.getBuilder()
                .setGradYear(2020)
                .setName("Stark")
                .setAge(25)
                .setUnivName("Marvel")
                .setBatch("CSE")
                .build();

        System.out.println("DEBUG");
    }
}

//Steps:-

/**
 *
 * 1. getBuilder() static method
 * 2. Make the Builder class static
 * 3. build method in Builder class.
 * 4. Make the setters of Builder class return Builder object.
 *
 *
 * Why we made setters return Builder object -> To support Method chaining.
 */

