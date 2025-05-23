package org.example.tictactoe.strategies.winningstrategy;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Move;
import org.example.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements  GameWinningStrategy{
    private final Map<Integer,Map<Symbol,Integer>> colMaps =new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();

        //First move in that col. Initialise the map in particular col.
        if (!colMaps.containsKey(col)){
            colMaps.put(col,new HashMap<>());
        }

        Map<Symbol,Integer> colMap= colMaps.get(col);
        if (colMap.containsKey(symbol)){
            colMap.put(symbol,colMap.get(symbol)+1);
        } else {
            colMap.put(symbol,1);
        }

        return colMap.get(symbol)==board.getSize();
        //In a particular row winner is considered if count of symbols is equal to size of board.

    }

    @Override
    public void handleUndo(Board board, Move move) {
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();

        Map<Symbol,Integer> colMap= colMaps.get(col);
        colMap.put(symbol,colMap.get(symbol) -1);

    }
}
