package br.com.ialmeida.tictactoe.pieces;

import br.com.ialmeida.tictactoe.Player;
import br.com.ialmeida.tictactoe.TicTacToePiece;

public class X extends TicTacToePiece {
    public X(Player player) {
        super(player);
    }

    @Override
    public String toString() {
        return "X";
    }
}
