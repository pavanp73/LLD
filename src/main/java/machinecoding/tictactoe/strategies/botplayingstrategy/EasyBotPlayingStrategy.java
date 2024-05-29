package machinecoding.tictactoe.strategies.botplayingstrategy;

import machinecoding.tictactoe.models.Board;
import machinecoding.tictactoe.models.Cell;
import machinecoding.tictactoe.models.CellState;
import machinecoding.tictactoe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {

        // iterate over the board and make a move
        // at the first empty cell

        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, null);
                }
            }
        }
        return null;
    }
}
