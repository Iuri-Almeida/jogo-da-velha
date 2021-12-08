package br.com.ialmeida.tictactoe.pieces;

import br.com.ialmeida.boardgame.Board;
import br.com.ialmeida.tictactoe.Player;
import br.com.ialmeida.tictactoe.TicTacToePiece;

public class X extends TicTacToePiece {
    public X(Board board, Player player) {
        super(board, player);
    }

    @Override
    public String toString() {
        return "X";
    }
}
