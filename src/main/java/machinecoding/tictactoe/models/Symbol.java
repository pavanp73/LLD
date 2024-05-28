package machinecoding.tictactoe.models;

public class Symbol {

    private char cChar;

    public Symbol() {
    }

    public Symbol(char cChar) {
        this.cChar = cChar;
    }

    public char getcChar() {
        return cChar;
    }

    public void setcChar(char cChar) {
        this.cChar = cChar;
    }
}
