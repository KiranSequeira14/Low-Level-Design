package org.tictactoe;

public class TicTacToe {
    private final int[] rows, cols;
    private int diagonal, antiDiagonal;
    private final int size;

    private int vis[][];

    public TicTacToe(int size) {
        rows = new int[size];
        cols = new int[size];
        diagonal = 0;
        antiDiagonal = 0;
        vis = new int[size][size];
        this.size = size;
    }

    /*Player {p1/p2} makes move call
     *@param player -> The player p1/p2 represented by 1/2
     *@param row -> selected row
     *@param col -> selected column
     *@return Current winning condition. It can be one of
     *   0: No one wins
     *   1: Player 1 wins
     *   2: Player 2 wins
     * */
    public int move(int player, int row, int col) throws Exception {
        int target = player == 1 ? this.size : -this.size;
        int toAdd = player == 1 ? 1 : -1;

        if (vis[row][col] != 0)
            throw new Exception("This block has already been selected");
        vis[row][col] = toAdd;

        //Diagonal case
        if (row == col) {
            this.diagonal += toAdd;
            if (this.diagonal == target)
                return player;
        }

        //AntiDiagonal case
        if (row + col == this.size - 1) {
            this.antiDiagonal += toAdd;
            if (this.antiDiagonal == target)
                return player;
        }

        this.rows[row] += toAdd;
        this.cols[col] += toAdd;

        if (this.cols[col] == target || this.rows[row] == target) return player;

        return 0;
    }

    public void display() {
        System.out.println();

        for (int i = 0; i < this.size; i++) {
            System.out.print("|");
            for (int j = 0; j < this.size; j++) {
                char c = vis[i][j] == 0 ? ' ' : vis[i][j] == -1 ? 'X' : 'O';
                System.out.print(c + " |");
            }
            System.out.println();
        }
    }
}
