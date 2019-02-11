package com.jaylookerstudios.tictactoe;

//stores information for human and computer player
public class Player {
    private int id;
    private String name;
    private int board_value;

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBoard_value() {
        return board_value;
    }

    public void setBoard_value(int board_value) {
        this.board_value = board_value;
    }

    //constructor
    public Player(int id, String name, int board_value) {
        this.id = id;
        this.name = name;
        this.board_value = board_value;
    }


    //plays a move to board
    public void play_move(int[][] board, Move move) {
        board[move.row][move.col] = this.board_value;
    }

    //use min-max algorithm to determine best move
    public Move get_best_move(int[][] board) {
        //todo finish min max algorithm
        Move move = new Move(0,0);
        return move;
    }

    //determines if current player is winning
    public boolean is_winning(int[][] board) {
        int winning_length = 3;
        for (int i = 0; i < board.length; i++) {
            int row_total = 0;
            int col_total = 0;
            int diagonal_up = 0;
            int diagonal_down = 0;
            for (int j = 0; j < board[i].length; j++) {
                //check each row
                if (board[i][j] == this.board_value) {
                    row_total++;

                    //check diagonal sloping down
                    if(i == j) {
                        diagonal_down++;
                    }
                }
                //check each col
                if(board[j][i] == this.board_value) {
                    col_total++;

                    //check diagonal sloping up
                    if (i != j) {
                        diagonal_up++;
                    }
                }
            }
            if (row_total == winning_length) { return true; }
            if (col_total == winning_length) { return true; }
            if (diagonal_down == winning_length) { return true; }
            if (diagonal_up == winning_length) { return true; }
        }
        return false;
    }
}

