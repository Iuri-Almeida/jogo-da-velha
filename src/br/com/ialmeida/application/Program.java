package br.com.ialmeida.application;

import br.com.ialmeida.tictactoe.TicTacToeMatch;

public class Program {
    public static void main(String[] args) {

        TicTacToeMatch match = new TicTacToeMatch();

        UI.printBoard(match.getPieces());

    }
}
