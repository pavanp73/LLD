package machinecoding.tictactoe.strategies.winningstrategy;

import machinecoding.tictactoe.models.Board;
import machinecoding.tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements GameWinningStrategy {
    private final Map<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Character currentChar = move.getPlayer().getSymbol().getcChar();

        if (!colMaps.containsKey(col)) {
            colMaps.put(col, new HashMap<>());
        }

        HashMap<Character, Integer> currColCharMap = colMaps.get(col);

        if (!currColCharMap.containsKey(currentChar)) {
            currColCharMap.put(currentChar, 0);
        }
        currColCharMap.put(currentChar, currColCharMap.get(currentChar) + 1);

        return currColCharMap.get(currentChar).equals(board.getSize());
    }
}
