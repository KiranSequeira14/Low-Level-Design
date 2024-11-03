package org.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the board size");
        int size = scanner.nextInt();

        TicTacToe ticTacToe = new TicTacToe(size);

        int winner = 0, maximumMoves = size * size, player = 1;
        for (int i = 0; winner == 0 && i < maximumMoves; i++) {
            ticTacToe.display();
            System.out.println("Player " + player + ": Choose your next row");
            int row = scanner.nextInt();
            System.out.println("Player " + player + ": Choose your next column");
            int col = scanner.nextInt();
            winner = ticTacToe.move(player, row, col);
            player = player == 1 ? 2 : 1;
        }

        System.out.println(winner == 0 ? "Match Drawn" : (winner+ " won the match").toUpperCase());
    }
}