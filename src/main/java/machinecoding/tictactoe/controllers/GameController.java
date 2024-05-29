package machinecoding.tictactoe.controllers;

import machinecoding.tictactoe.models.Game;
import machinecoding.tictactoe.models.GameState;
import machinecoding.tictactoe.models.Player;
import machinecoding.tictactoe.strategies.winningstrategy.GameWinningStrategy;

import java.util.List;

public class GameController {

    // make move

    // undo

    // check winner

    // check game state

    public Game startGame(int size, List<Player> players, List<GameWinningStrategy> gameWinningStrategies) {
        return Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .setGameWinningStrategies(gameWinningStrategies)
                .build();
    }

    public void makeMove(Game game) {
        return;
    }

    public GameState checkGameState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return null;
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void undo(Game game) {

    }
}
