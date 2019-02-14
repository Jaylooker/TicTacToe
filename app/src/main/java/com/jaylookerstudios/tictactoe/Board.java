package com.jaylookerstudios.tictactoe;

public class Board {
    private int[][] board;

    //getters and setters
    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    //constructor
    public Board() {
        this.board = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = BoardValue.EMPTY.getBoard_value();
            }
        }
    }

    //methods
    public boolean is_full() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                    if(this.board[i][j] == BoardValue.EMPTY.getBoard_value()) {
                        return false;
                    }
            }
        }
        return true;
    }
}