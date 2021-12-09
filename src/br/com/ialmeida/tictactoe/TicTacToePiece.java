package br.com.ialmeida.tictactoe;

import br.com.ialmeida.boardgame.Piece;

public class TicTacToePiece extends Piece {

    private final Player player;

    public TicTacToePiece(Player player) {
        super();
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return player.toString();
    }
}
