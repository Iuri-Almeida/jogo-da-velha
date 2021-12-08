package br.com.ialmeida.application;

import br.com.ialmeida.tictactoe.TicTacToeMatch;
import br.com.ialmeida.tictactoe.TicTacToePosition;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicTacToeMatch match = new TicTacToeMatch();

        while (true) {

            UI.printBoard(match.getPieces());

            System.out.println();
            System.out.print("Target: ");

            TicTacToePosition target = UI.readTicTacToePosition(sc);

            match.performMove(target);

        }

//        sc.close();

    }
}
