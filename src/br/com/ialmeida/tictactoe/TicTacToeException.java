package br.com.ialmeida.tictactoe;

import br.com.ialmeida.boardgame.BoardException;

public class TicTacToeException extends BoardException {
    public TicTacToeException(String msg) {
        super(msg);
    }
}
