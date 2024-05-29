package machinecoding.tictactoe.strategies.winningstrategy;

import machinecoding.tictactoe.models.Board;
import machinecoding.tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements GameWinningStrategy {

    private final Map<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Character currentChar = move.getPlayer().getSymbol().getcChar();

        if (!rowMaps.containsKey(row)) {
            rowMaps.put(row, new HashMap<>());
        }

        HashMap<Character, Integer> currRowCharMap = rowMaps.get(row);

        if (!currRowCharMap.containsKey(currentChar)) {
            currRowCharMap.put(currentChar, 0);
        }
        currRowCharMap.put(currentChar, currRowCharMap.get(currentChar) + 1);

        return currRowCharMap.get(currentChar).equals(board.getSize());

    }
}
