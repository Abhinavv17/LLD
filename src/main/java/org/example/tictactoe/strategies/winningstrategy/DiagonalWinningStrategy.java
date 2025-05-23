package org.example.tictactoe.strategies.winningstrategy;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Move;
import org.example.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements GameWinningStrategy{
    private Map<Symbol,Integer> leftDiagonal=new HashMap<>();
    private Map<Symbol,Integer> rightDiagonal=new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        Symbol symbol=move.getPlayer().getSymbol();
        int row=move.getCell().getRow();
        int col= move.getCell().getCol();

        //Left Diagonal
        if (row==col){
            if(!leftDiagonal.containsKey(symbol)){  // symbol  not present then put 0.
                leftDiagonal.put(symbol,0);
            }
            else {
                leftDiagonal.put(symbol,leftDiagonal.get(symbol)+1);
            }

        }

        //Right Diagonal
        if (row + col==board.getSize()-1) {
            if (!rightDiagonal.containsKey(symbol)) {  // symbol  not present then put 0.
                rightDiagonal.put(symbol, 0);
            } else {
                rightDiagonal.put(symbol, rightDiagonal.get(symbol) + 1);
            }
        }

        if(row==col && leftDiagonal.get(symbol).equals(board.getSize())){
            return true;
        }
        if (row+col==board.getSize()-1 && rightDiagonal.get(symbol).equals(board.getSize())){
            return true;
        }


        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();

        //update left diagonal
        if (row==col){
            leftDiagonal.put(symbol,leftDiagonal.get(symbol)-1);
        }

        //update right diagonal
        if (row+col==board.getSize()-1){
            rightDiagonal.put(symbol,rightDiagonal.get(symbol)-1);
        }


    }
}
