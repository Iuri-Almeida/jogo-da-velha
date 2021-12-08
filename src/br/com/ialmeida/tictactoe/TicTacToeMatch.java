package br.com.ialmeida.tictactoe;

import br.com.ialmeida.boardgame.Board;

public class TicTacToeMatch {

    private final Board board;

    public TicTacToeMatch() {
        board = new Board(3, 3);
    }

    public TicTacToePiece[][] getPieces() {

        int rows = board.getRows();
        int columns = board.getColumns();

        TicTacToePiece[][] pieces = new TicTacToePiece[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                pieces[i][j] = (TicTacToePiece) board.piece(i, j);
            }
        }

        return pieces;
    }
}
