package org.example.interfaces;

public class Client {
    public static void main(String[] args) {

//        Cat cat = new Cat();
//        Dog dog = new Dog();
//        cat.eat();
//        cat.run();
//        cat.walk();


        Animal animal = new Dog();
        animal.eat();
        animal.walk();
        animal.run();
    }
}
