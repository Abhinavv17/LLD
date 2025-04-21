package org.example.tictactoe.strategies.winningstrategy;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Move;
import org.example.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements GameWinningStrategy{
    private final Map<Integer,Map<Symbol,Integer>> rowMaps=new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();

        //First move in that row. Initialise the map in particular row.
        if (!rowMaps.containsKey(row)){
            rowMaps.put(row,new HashMap<>());
        }

        Map<Symbol,Integer> rowMap=rowMaps.get(row);
        if (rowMap.containsKey(symbol)){
            rowMap.put(symbol,rowMap.get(symbol)+1);
        } else {
            rowMap.put(symbol,1);
        }

        return rowMap.get(symbol)==board.getSize();
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();

        Map<Symbol,Integer> rowMap= rowMaps.get(row);
        rowMap.put(symbol,rowMap.get(symbol) -1);

    }
}
