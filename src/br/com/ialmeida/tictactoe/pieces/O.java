package br.com.ialmeida.tictactoe.pieces;

import br.com.ialmeida.boardgame.Board;
import br.com.ialmeida.tictactoe.Player;
import br.com.ialmeida.tictactoe.TicTacToePiece;

public class O extends TicTacToePiece {
    public O(Board board, Player player) {
        super(board, player);
    }

    @Override
    public String toString() {
        return "O";
    }

    @Override
    public boolean[][] possibleMoves() {
        return new boolean[getBoard().getRows()][getBoard().getColumns()];
    }
}
