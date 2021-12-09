package br.com.ialmeida.tictactoe.pieces;

import br.com.ialmeida.tictactoe.Player;
import br.com.ialmeida.tictactoe.TicTacToePiece;

public class O extends TicTacToePiece {
    public O(Player player) {
        super(player);
    }

    @Override
    public String toString() {
        return "O";
    }
}
