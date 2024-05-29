package machinecoding.tictactoe.models;

public class Cell {

    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    public Cell(int row, int col) {
        this.cellState = CellState.EMPTY;
        this.col = col;
        this.row = row;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void display() {
        if (player == null) {
            System.out.print("|--|");
        } else {
            System.out.print("|" + player.getSymbol().getcChar() + "|");
        }
    }
}
