package br.com.ialmeida.application;

import br.com.ialmeida.tictactoe.TicTacToePiece;

public class UI {

    public static void printBoard(TicTacToePiece[][] pieces) {

        int rows = pieces.length;
        int columns = pieces[0].length;

        for (int i = 0; i < rows; i++) {

            System.out.print((rows - i) + " ");

            for (int j = 0; j < columns; j++) {

                TicTacToePiece piece = pieces[i][j];

                System.out.print(((piece == null) ? "-" : piece) + " ");

            }

            System.out.println();
        }

        System.out.println("  a b c");

    }
}
