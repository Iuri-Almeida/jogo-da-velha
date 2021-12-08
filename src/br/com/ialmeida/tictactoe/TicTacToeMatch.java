package br.com.ialmeida.tictactoe;

import br.com.ialmeida.boardgame.Board;
import br.com.ialmeida.boardgame.Position;
import br.com.ialmeida.tictactoe.pieces.O;
import br.com.ialmeida.tictactoe.pieces.X;

public class TicTacToeMatch {

    private final Board board;

    public TicTacToeMatch() {
        board = new Board(3, 3);

        initialSetup();
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

    private void initialSetup() {
        board.placePiece(new X(board, Player.X), new Position(0, 1));
        board.placePiece(new O(board, Player.O), new Position(1, 1));
        board.placePiece(new X(board, Player.X), new Position(2, 2));
    }
}
