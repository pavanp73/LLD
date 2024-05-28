package machinecoding.tictactoe.strategies.botplayingstrategy;

import machinecoding.tictactoe.models.Board;
import machinecoding.tictactoe.models.Move;

public interface BotPlayingStrategy {

    Move makeMove(Board board);
}
