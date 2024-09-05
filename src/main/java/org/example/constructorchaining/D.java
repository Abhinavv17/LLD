package org.example.constructorchaining;

public class D extends C {
    D() {
//        super();
        super("abcd"); // C("abcd")
        System.out.println("D's constructor");

    }
}
