package machinecoding.tictactoe.models;

import machinecoding.tictactoe.strategies.winningstrategy.GameWinningStrategy;

import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerIndex;
    private List<GameWinningStrategy> gameWinningStrategies;
}
