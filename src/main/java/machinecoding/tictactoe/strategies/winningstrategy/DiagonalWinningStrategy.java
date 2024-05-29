package machinecoding.tictactoe.strategies.winningstrategy;

import machinecoding.tictactoe.models.Board;
import machinecoding.tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements GameWinningStrategy {

    private final Map<Character, Integer> leftDiagonalMap = new HashMap<>();
    private final Map<Character, Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character currentChar = move.getPlayer().getSymbol().getcChar();

        if (row == col) {
            if (!leftDiagonalMap.containsKey(currentChar)) {
                leftDiagonalMap.put(currentChar, 0);
            }
            leftDiagonalMap.put(currentChar, leftDiagonalMap.get(currentChar));
        }

        if (row + col == board.getSize() - 1) {
            if (!rightDiagonalMap.containsKey(currentChar)) {
                rightDiagonalMap.put(currentChar, 0);
            }
            rightDiagonalMap.put(currentChar, rightDiagonalMap.get(currentChar));
        }

        return (row == col &&
                leftDiagonalMap.get(currentChar).equals(board.getSize())) ||
                (row + col == board.getSize() - 1 &&
                        rightDiagonalMap.get(currentChar).equals(board.getSize()));

    }
}
