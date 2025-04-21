package org.example.tictactoe;

import org.example.tictactoe.controllers.GameController;
import org.example.tictactoe.exceptions.InvalidBotCountException;
import org.example.tictactoe.exceptions.InvalidMoveException;
import org.example.tictactoe.exceptions.InvalidNumberOfPlayersException;
import org.example.tictactoe.models.Game;
import org.example.tictactoe.models.GameState;
import org.example.tictactoe.models.Player;
import org.example.tictactoe.models.Symbol;
import org.example.tictactoe.strategies.winningstrategy.ColWinningStrategy;
import org.example.tictactoe.strategies.winningstrategy.DiagonalWinningStrategy;
import org.example.tictactoe.strategies.winningstrategy.GameWinningStrategy;
import org.example.tictactoe.strategies.winningstrategy.RowWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidMoveException, InvalidBotCountException, InvalidNumberOfPlayersException {
        GameController controller = new GameController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the game dimension");

        int dimension = scanner.nextInt();

        List<Player> players= List.of(
                new Player("Stark",new Symbol('X')),
                new Player("Thanos",new Symbol('O'))
        );

        List<GameWinningStrategy> winningStrategies=List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        Game game = controller.startGame(dimension, players, winningStrategies);
        controller.displayBoard(game);

        while (controller.getGameState(game).equals(GameState.IN_PROGRESS)) {
            controller.displayBoard(game);

            System.out.println("Do you want to undo ?");
            String moveNext = scanner.next();

            if (moveNext.equalsIgnoreCase("y")) {
                controller.undo(game);
                continue;

            }
            controller.makeMove(game);
        }
        //while loop will be over if game has ended or game has drawn.

        System.out.println("Game has finished!");
        controller.displayBoard(game);

        if (controller.getGameState(game).equals(GameState.ENDED)) {
            System.out.println("Winner is " + controller.getWinner(game).getName());
        } else {
            System.out.println("Game Drawn");
        }

    }
}
