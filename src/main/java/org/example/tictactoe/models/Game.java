package org.example.tictactoe.models;

import org.example.tictactoe.exceptions.InvalidBotCountException;
import org.example.tictactoe.exceptions.InvalidMoveException;
import org.example.tictactoe.exceptions.InvalidNumberOfPlayersException;
import org.example.tictactoe.strategies.winningstrategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;

    private Board board;
    private Player winner;
    private int nextMovePlayerIndex;

    private GameState gameState;
    private List<Move> moves;

    private List<GameWinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<GameWinningStrategy> winningStrategies){
        this.moves=new ArrayList<>();
        this.gameState=GameState.IN_PROGRESS;
        this.nextMovePlayerIndex=0;
        this.winner=null;
        this.winningStrategies=winningStrategies;
        this.players=players;
        this.board=new Board(dimension);

    }

    public static Builder getBuilder(){
        return new Builder();
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<GameWinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<GameWinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public static class Builder {
        private List<Player> players;
        private List<GameWinningStrategy> winningStrategies;
        private int dimension;

        private Builder(){
            this.players=new ArrayList<>();
            this.winningStrategies=new ArrayList<>();
            this.dimension=0;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<GameWinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        private boolean validateBotCount(){
            int botCount=0;
            for (Player player: players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }
            return botCount<=1;
        }

        private void validate() throws InvalidNumberOfPlayersException, InvalidBotCountException {
            if(players.size() != dimension-1){
                throw new InvalidNumberOfPlayersException("Numbers of Players should be 1 less than Dimension");

            }
            //Validate if all the players have same symbols or not
            //TO Do


            //validate number of bots in the game
            if(!validateBotCount()){
                throw new InvalidBotCountException("Bot count should be <=1");
            }
        }

        public Game build() throws InvalidNumberOfPlayersException, InvalidBotCountException {
            //Validations
            validate();
            return new Game(dimension,players,winningStrategies);

        }
    }

    private boolean validateMove(Move move){
        int row=move.getCell().getRow();
        int col =move.getCell().getCol();

        if (row<0 || row>=board.getSize() || col < 0 || col>=board.getSize()){
            return  false;
        }
        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer=players.get(nextMovePlayerIndex);


        System.out.println("It is "+currentPlayer.getName()+"'s Move");

        Move currrentMove=currentPlayer.executeMove(board);
        int row=currrentMove.getCell().getRow();
        int col=currrentMove.getCell().getCol();

        System.out.println(currentPlayer.getName()+ " has made move at row " +row+ "& col " +col);
        if(!validateMove(currrentMove)){
            throw new InvalidMoveException("Player is trying to make invalid move");

        }

        nextMovePlayerIndex=(nextMovePlayerIndex+1)%players.size();

        Cell cell=board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        Move finalMove=new Move(cell,currentPlayer);
        moves.add(finalMove);
        //check if the move made by player is winning move or not.

        if(checkWinner(board,finalMove)){
            gameState=GameState.ENDED;
            winner=currentPlayer;
        } else if (moves.size()==board.getSize()* board.getSize()) {
            gameState=GameState.DRAW;
            
        }

    }

    private boolean checkWinner(Board board, Move move){
        //Check all the strategies one by one to check if the current move is winning move or not.
        for (GameWinningStrategy winningStrategy: winningStrategies){
            if(winningStrategy.checkWinner(board,move)){
                return true;
            }
        }

        return  false;
    }

    public void undo(){
        if(moves.isEmpty()){
            System.out.println("We can't perform undo as there is NO move");
            return;
        }

        Move lastmove=moves.get(moves.size()-1);
        moves.remove(lastmove);

        Cell cell=lastmove.getCell();
        cell.setPlayer(null);
        cell.setCellState(CellState.EMPTY);

        nextMovePlayerIndex -= 1;
        nextMovePlayerIndex=(nextMovePlayerIndex+players.size())%players.size();

        for (GameWinningStrategy gameWinningStrategy : winningStrategies){
            gameWinningStrategy.handleUndo(board,lastmove);
        }
        
    }
}

