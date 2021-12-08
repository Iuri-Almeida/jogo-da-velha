package br.com.ialmeida.tictactoe;

import br.com.ialmeida.application.ProgramConstants;
import br.com.ialmeida.boardgame.Board;
import br.com.ialmeida.boardgame.Position;
import br.com.ialmeida.tictactoe.pieces.O;
import br.com.ialmeida.tictactoe.pieces.X;

public class TicTacToeMatch {

    private final Board board;

    public TicTacToeMatch() {
        board = new Board(ProgramConstants.ROWS, ProgramConstants.COLUMNS);

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

    public boolean[][] possibleMoves() {
        return board.possibleMoves();
    }

    public void performMove(TicTacToePosition targetPosition) {
        Position target = targetPosition.toPosition();
        makeMove(target);
    }

    private void makeMove(Position target) {
        board.placePiece(new X(board, Player.X), target);
    }

    private void placeNewPiece(char column, int row, TicTacToePiece piece) {
        board.placePiece(piece, new TicTacToePosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('a', 1, new O(board, Player.O));
        placeNewPiece('b', 2, new X(board, Player.X));
        placeNewPiece('c', 3, new O(board, Player.O));
        placeNewPiece('a', 2, new X(board, Player.X));
    }
}
