package org.example.tictactoe.models;

import java.util.Scanner;

public class Player {
    private Long id;

    private String name;

    private Symbol symbol;

    private PlayerType playerType;

    public Long getId() {
        return id;
    }

    public Player(String name,Symbol symbol){
        this.name=name;
        this.symbol=symbol;
        this.playerType=PlayerType.HUMAN;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move executeMove(Board board){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter the row where you want to make move");
        int row=scanner.nextInt();

        System.out.println("Please enter the col where you want to make move");
        int col=scanner.nextInt();

        return new Move(new Cell(row,col),this);
    }
}
