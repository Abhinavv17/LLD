package org.example.interfaces;

public class Cat implements  Animal{

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void walk() {
        System.out.println("cat is walking");

    }

    @Override
    public void run() {
        System.out.println("cat is running");

    }
}
