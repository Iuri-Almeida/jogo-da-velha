package br.com.ialmeida.application;

import br.com.ialmeida.boardgame.BoardException;
import br.com.ialmeida.tictactoe.TicTacToeMatch;
import br.com.ialmeida.tictactoe.TicTacToePosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicTacToeMatch match = new TicTacToeMatch();

        while (match.isGameOver()) {

            try {
                UI.clearScreen();
                UI.printMatch(match, match.possibleMoves());

                System.out.println();
                System.out.print("Target: ");

                TicTacToePosition target = UI.readTicTacToePosition(sc);

                match.performMove(target);
            } catch (BoardException | InputMismatchException e) {
                System.out.println(e.getMessage() + "\n");
                System.out.println("Click ENTER to continue.");
                sc.nextLine();
            }

        }

        sc.close();

        UI.clearScreen();
        UI.printMatch(match, match.possibleMoves());

    }
}
