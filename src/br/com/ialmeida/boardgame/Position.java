package br.com.ialmeida.boardgame;

public class Position {
    private byte row;
    private byte column;

    public Position(byte row, byte column) {
        this.row = row;
        this.column = column;
    }

    public byte getRow() {
        return row;
    }

    public void setRow(byte row) {
        this.row = row;
    }

    public byte getColumn() {
        return column;
    }

    public void setColumn(byte column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }
}
