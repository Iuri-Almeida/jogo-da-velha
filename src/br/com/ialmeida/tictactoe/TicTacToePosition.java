package br.com.ialmeida.tictactoe;

import br.com.ialmeida.application.ProgramConstants;
import br.com.ialmeida.boardgame.Position;

public class TicTacToePosition {

    private final int row;
    private final char column;

    public TicTacToePosition(char column, int row) {

        if (column < ProgramConstants.FIRST_COLUMN || column > ProgramConstants.LAST_COLUMN ||
                row < 1 || row > ProgramConstants.ROWS) {
            throw new TicTacToeException("Error instantiating ChessPosition. Valid values are from a1 to c3.");
        }

        this.row = row;
        this.column = column;
    }

    public Position toPosition() {

        int row = ProgramConstants.ROWS - this.row;
        int column = this.column - ProgramConstants.FIRST_COLUMN;

        return new Position(row, column);
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
