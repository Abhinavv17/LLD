package org.example.tictactoe.exceptions;

public class InvalidMoveException extends Exception{
    public InvalidMoveException(String message){
        super(message);
    }
}
