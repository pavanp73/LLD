package machinecoding.tictactoe.models;

public class Move {

    private Move move;
    private Cell cell;

    public Move(Cell cell, Move move) {
        this.cell = cell;
        this.move = move;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
