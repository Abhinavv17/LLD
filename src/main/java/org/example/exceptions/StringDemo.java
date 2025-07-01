package org.example.exceptions;

import java.sql.SQLOutput;

public class StringDemo {
    public static void main(String[] args) {
        String s1="Stark";
        String s2="Stark";
        //String s3="stark";
        String s4= new String("Stark");
        String s5=new String("Stark");

        System.out.println((s1==s2)+ " " + (s1.equals(s2)));
        System.out.println((s1==s4)+ " " + (s1.equals(s4)));
        System.out.println((s2==s4)+ " " + (s2.equals(s4)));
        System.out.println((s4==s5)+ " " + (s4.equals(s5)));

        System.out.println("Debug");
    }
}
