package machinecoding.tictactoe.strategies.winningstrategy;

import machinecoding.tictactoe.models.Board;
import machinecoding.tictactoe.models.Move;

public interface GameWinningStrategy {

    boolean checkWinner(Board board, Move move);
}
