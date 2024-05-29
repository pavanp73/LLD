package machinecoding.tictactoe;

import machinecoding.tictactoe.controllers.GameController;
import machinecoding.tictactoe.models.BotDifficultyLevel;
import machinecoding.tictactoe.models.BotPlayer;
import machinecoding.tictactoe.models.Game;
import machinecoding.tictactoe.models.GameState;
import machinecoding.tictactoe.models.Player;
import machinecoding.tictactoe.models.PlayerType;
import machinecoding.tictactoe.models.Symbol;
import machinecoding.tictactoe.strategies.winningstrategy.ColWinningStrategy;
import machinecoding.tictactoe.strategies.winningstrategy.DiagonalWinningStrategy;
import machinecoding.tictactoe.strategies.winningstrategy.GameWinningStrategy;
import machinecoding.tictactoe.strategies.winningstrategy.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain {

    public static void main(String[] args) {
        System.out.println("Game Starts");
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        int size = 3;

        List<Player> players = new ArrayList<>();
        players.add(new Player("Pavan", PlayerType.HUMAN, new Symbol('#')));
        players.add(new BotPlayer("Scaler-BOT",PlayerType.BOT, new Symbol('O'), BotDifficultyLevel.EASY));

        List<GameWinningStrategy> gameWinningStrategies= List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        Game game = gameController.startGame(size, players, gameWinningStrategies);

        //gameController.printBoard(game);

        // Let's play the game

        while (GameState.IN_PROGRESS.equals(gameController.checkGameState(game))) {
            // show the board
            // make a move

            gameController.printBoard(game);
            System.out.println("Do you want to undo? Y/N or Yes/No");
            String isUndo = scanner.next();

            if (isUndo.equalsIgnoreCase("Y") ||
                    isUndo.equalsIgnoreCase("Yes")) {
                // undo operation
                gameController.undo(game);
                // continue
            }

            gameController.makeMove(game);
        }

        System.out.println("DEBUG");
    }
}
