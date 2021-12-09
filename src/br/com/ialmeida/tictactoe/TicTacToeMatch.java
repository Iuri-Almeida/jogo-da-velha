package br.com.ialmeida.tictactoe;

import br.com.ialmeida.application.ProgramConstants;
import br.com.ialmeida.boardgame.Board;
import br.com.ialmeida.boardgame.Piece;
import br.com.ialmeida.boardgame.Position;

public class TicTacToeMatch {

    private int turn;
    private Player currentPlayer;
    private final Board board;
    private boolean gameOver;
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

    public boolean isGameOver() {
        return !gameOver;
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

        gameOver = testEndGame();

        if (!gameOver) {
            nextTurn();
        }
    }

    private void makeMove(Position target) {
        Piece piece = (currentPlayer == Player.X) ? new TicTacToePiece(Player.X) : new TicTacToePiece(Player.O);
        board.placePiece(piece, target);
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
    }

    private boolean testLines(TicTacToePiece[][] pieces) {
        boolean l = false;

        for (TicTacToePiece[] piece : pieces) {
            if (piece[0] != null && piece[1] != null && piece[2] != null) {
                l = piece[0].getPlayer() == piece[1].getPlayer() && piece[0].getPlayer() == piece[2].getPlayer();
            }
        }

        return l;
    }

    private boolean testColumns(TicTacToePiece[][] pieces) {
        boolean c = false;

        for (int i = 0; i < pieces.length; i++) {
            if (pieces[0][i] != null && pieces[1][i] != null && pieces[2][i] != null) {
                c = pieces[0][i].getPlayer() == pieces[1][i].getPlayer() && pieces[0][i].getPlayer() == pieces[2][i].getPlayer();
            }
        }

        return c;
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

        boolean[][] moves = board.possibleMoves();

        for (boolean[] move : moves) {
            for (int j = 0; j < moves[0].length; j++) {
                if (move[j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
