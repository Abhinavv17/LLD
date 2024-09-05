package org.example.inheritance2;

public class Client {
    public static void main(String[] args) {
        A a =new C();

        a.age=28;
        a.name="Abhinav";

//        a.companyName="ABCD";

        //Note - Because compiler only knows about the left side i.e the type of variable we are creating,
        //Compiler doesn't know about what type of object we are going to store in the variable,
        //as the object creation happens at Run Time.

        System.out.println("DEBUG");


    }
}
