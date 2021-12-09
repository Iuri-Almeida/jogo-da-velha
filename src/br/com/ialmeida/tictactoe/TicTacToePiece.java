package br.com.ialmeida.tictactoe;

import br.com.ialmeida.boardgame.Board;
import br.com.ialmeida.boardgame.Piece;

public class TicTacToePiece extends Piece {

    private final Player player;

    public TicTacToePiece(Board board, Player player) {
        super(board);
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

}
