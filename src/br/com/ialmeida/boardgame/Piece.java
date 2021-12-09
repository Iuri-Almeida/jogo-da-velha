package br.com.ialmeida.boardgame;

public abstract class Piece {

    protected Position position;
    private final Board board;

    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

}
