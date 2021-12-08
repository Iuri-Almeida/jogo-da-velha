package br.com.ialmeida.application;

import br.com.ialmeida.tictactoe.Player;
import br.com.ialmeida.tictactoe.TicTacToePiece;

public class UI {

    public static void printBoard(TicTacToePiece[][] pieces) {

        int rows = pieces.length;
        int columns = pieces[0].length;

        for (int i = 0; i < rows; i++) {

            System.out.print((rows - i) + " ");

            for (int j = 0; j < columns; j++) {

                printPiece(pieces[i][j]);

            }

            System.out.println();
        }

        System.out.println("  a b c");

    }

    private static void printPiece(TicTacToePiece piece) {
        if (piece == null) {
            System.out.print("-");
        } else {

            if (piece.getPlayer() == Player.X) {
                System.out.print(ProgramConstants.X_PIECE_COLOR + piece + ProgramConstants.RESET_COLOR);
            } else {
                System.out.print(ProgramConstants.O_PIECE_COLOR + piece + ProgramConstants.RESET_COLOR);
            }

        }

        System.out.print(" ");
    }
}
