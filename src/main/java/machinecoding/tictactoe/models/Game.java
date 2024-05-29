package machinecoding.tictactoe.models;

import machinecoding.tictactoe.strategies.winningstrategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerIndex;
    private List<GameWinningStrategy> gameWinningStrategies;

    private Game(int size, List<Player> players, List<GameWinningStrategy> gameWinningStrategies) {
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.gameWinningStrategies = gameWinningStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<GameWinningStrategy> getGameWinningStrategies() {
        return gameWinningStrategies;
    }

    public void setGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
        this.gameWinningStrategies = gameWinningStrategies;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void printBoard() {
        board.printBoard();
    }

    public void makeMove() {
        Player currentPlayer = players.get(nextPlayerIndex);

        System.out.println("This is " + currentPlayer.getName() + "'s move");

        // player will choose that they want to make
        Move move = currentPlayer.makeMove(board);

        // game will validate the move that the player has chosen is valid or not
        if (!validateMove(move)) {
            throw new RuntimeException("Invalid move. Please retry");
        }

        // move is valid so apply move to the board
        Cell boardCell = board.getCell(move.getCell().getRow(), move.getCell().getCol());
        boardCell.setCellState(CellState.FILLED);
        boardCell.setPlayer(currentPlayer);
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

        Move finalMove = new Move(boardCell, currentPlayer);
        moves.add(finalMove);

        if (checkWinner(finalMove)) {
            winner = currentPlayer;
            gameState = GameState.ENDED;
        } else if (moves.size() == board.getSize() * board.getSize()) {
            gameState = GameState.DRAW;
        }
    }

    private boolean checkWinner(Move move) {
        for (GameWinningStrategy winningStrategy : gameWinningStrategies) {
            if (winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= board.getSize() || col < 0 && col >= board.getSize()) {
            return false;
        }

        if (!board.getCell(row, col).getCellState().equals(CellState.EMPTY)) {
            return false;
        }
        return true;
    }

    public static class Builder {
        private int size;
        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;

        private Builder() {
            this.size = 0;
            this.players = new ArrayList<>();
            this.gameWinningStrategies = new ArrayList<>();
        }

        public List<GameWinningStrategy> getGameWinningStrategies() {
            return gameWinningStrategies;
        }

        public Builder setGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
            this.gameWinningStrategies = gameWinningStrategies;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public int getSize() {
            return size;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Game build() {
            validations();
            return new Game(size, players, gameWinningStrategies);
        }

        private void validations() {
            if (size <= 0) {
                throw new RuntimeException("Size cannot be negative");
            }

            int count = 0;
            for (Player player : players) {
                if (PlayerType.BOT.equals(player.getPlayerType())) {
                    count++;
                }
                if (count > 1) {
                    throw new RuntimeException("Only one BOT is allowed per game");
                }
            }

            Set<Character> symbolSet = new HashSet<>();
            for (Player player : players) {
                symbolSet.add(player.getSymbol().getcChar());
            }
            if (symbolSet.size() != size - 1) {
                throw new RuntimeException("Every player should have unique symbols");
            }
        }
    }
}
