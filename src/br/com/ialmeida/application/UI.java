package br.com.ialmeida.application;

import br.com.ialmeida.tictactoe.Player;
import br.com.ialmeida.tictactoe.TicTacToePiece;
import br.com.ialmeida.tictactoe.TicTacToePosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static TicTacToePosition readTicTacToePosition(Scanner sc) {

        try {
            String s = sc.nextLine();

            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            return new TicTacToePosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to c3.");
        }

    }

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
