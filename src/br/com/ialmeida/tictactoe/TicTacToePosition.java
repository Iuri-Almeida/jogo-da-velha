package br.com.ialmeida.tictactoe;

import br.com.ialmeida.application.ProgramConstants;
import br.com.ialmeida.boardgame.Position;

public class TicTacToePosition {

    private int row;
    private char column;

    public TicTacToePosition(char column, int row) {

        if (column < ProgramConstants.FIRST_COLUMN || column > ProgramConstants.LAST_COLUMN ||
                row < 1 || row > ProgramConstants.ROWS) {
            throw new TicTacToeException("Error instantiating ChessPosition. Valid values are from a1 to c3.");
        }

        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    public Position toPosition() {

        int row = ProgramConstants.ROWS - this.row;
        int column = this.column - ProgramConstants.FIRST_COLUMN;

        return new Position(row, column);
    }

    public static TicTacToePosition fromPosition(Position position) {

        int row = ProgramConstants.ROWS - position.getRow();
        char column = (char) (ProgramConstants.FIRST_COLUMN - position.getColumn());

        return new TicTacToePosition(column, row);
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
