package org.example.exceptions;

public class Pair {
    String first;
    String second;

    Pair(String first,String second){
        if(first==null && second==null ){
            throw new RuntimeException("First and second attribute can't be null");

        }
        this.first=first;
        this.second=second;

    }
}
