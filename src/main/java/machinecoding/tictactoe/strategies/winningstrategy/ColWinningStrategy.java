package machinecoding.tictactoe.strategies.winningstrategy;

import machinecoding.tictactoe.models.Board;
import machinecoding.tictactoe.models.Move;

public class ColWinningStrategy implements GameWinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
