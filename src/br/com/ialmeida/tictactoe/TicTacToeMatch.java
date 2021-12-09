package br.com.ialmeida.tictactoe;

import br.com.ialmeida.application.ProgramConstants;
import br.com.ialmeida.boardgame.Board;
import br.com.ialmeida.boardgame.Piece;
import br.com.ialmeida.boardgame.Position;
import br.com.ialmeida.tictactoe.pieces.O;
import br.com.ialmeida.tictactoe.pieces.X;

public class TicTacToeMatch {

    private int turn;
    private Player currentPlayer;
    private final Board board;
    private boolean gameEnded;
    private boolean hasWinner;

    public TicTacToeMatch() {
        board = new Board(ProgramConstants.ROWS, ProgramConstants.COLUMNS);
        turn = 1;
        currentPlayer = Player.X;
    }

    public int getTurn() {
        return turn;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public boolean hasWinner() {
        return hasWinner;
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

        gameEnded = testEndGame();

        if (!gameEnded) {
            nextTurn();
        }
    }

    private void makeMove(Position target) {
        Piece piece = (currentPlayer == Player.X) ? new X(board, Player.X) : new O(board, Player.O);
        board.placePiece(piece, target);
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
    }

    private boolean testLines(TicTacToePiece[][] pieces) {
        boolean l1 = false;
        boolean l2 = false;
        boolean l3 = false;

        if (pieces[0][0] != null && pieces[0][1] != null && pieces[0][2] != null) {
            l1 = pieces[0][0].getPlayer() == pieces[0][1].getPlayer() && pieces[0][0].getPlayer() == pieces[0][2].getPlayer();
        }

        if (pieces[1][0] != null && pieces[1][1] != null && pieces[1][2] != null) {
            l2 = pieces[1][0].getPlayer() == pieces[1][1].getPlayer() && pieces[1][0].getPlayer() == pieces[1][2].getPlayer();
        }

        if (pieces[2][0] != null && pieces[2][1] != null && pieces[2][2] != null) {
            l3 = pieces[2][0].getPlayer() == pieces[2][1].getPlayer() && pieces[2][0].getPlayer() == pieces[2][2].getPlayer();
        }

        return l1 || l2 || l3;
    }

    private boolean testColumns(TicTacToePiece[][] pieces) {
        boolean c1 = false;
        boolean c2 = false;
        boolean c3 = false;

        if (pieces[0][0] != null && pieces[1][0] != null && pieces[2][0] != null) {
            c1 = pieces[0][0].getPlayer() == pieces[1][0].getPlayer() && pieces[0][0].getPlayer() == pieces[2][0].getPlayer();
        }

        if (pieces[0][1] != null && pieces[1][1] != null && pieces[2][1] != null) {
            c2 = pieces[0][1].getPlayer() == pieces[1][1].getPlayer() && pieces[0][1].getPlayer() == pieces[2][1].getPlayer();
        }

        if (pieces[0][2] != null && pieces[1][2] != null && pieces[2][2] != null) {
            c3 = pieces[0][2].getPlayer() == pieces[1][2].getPlayer() && pieces[0][2].getPlayer() == pieces[2][2].getPlayer();
        }

        return c1 || c2 || c3;
    }

    private boolean testDiagonal(TicTacToePiece[][] pieces) {
        boolean d1 = false;
        boolean d2 = false;

        if (pieces[0][0] != null && pieces[1][1] != null && pieces[2][2] != null) {
            d1 = pieces[0][0].getPlayer() == pieces[1][1].getPlayer() && pieces[0][0].getPlayer() == pieces[2][2].getPlayer();
        }

        if (pieces[0][2] != null && pieces[1][1] != null && pieces[2][0] != null) {
            d2 = pieces[0][2].getPlayer() == pieces[1][1].getPlayer() && pieces[0][2].getPlayer() == pieces[2][0].getPlayer();
        }

        return d1 || d2;
    }

    private boolean testWinner() {
        TicTacToePiece[][] pieces = getPieces();
        hasWinner = testLines(pieces) || testColumns(pieces) || testDiagonal(pieces);
        return hasWinner;
    }

    private boolean testEndGame() {

        if (testWinner()) {
            return true;
        }

        boolean[][] mat = board.possibleMoves();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
