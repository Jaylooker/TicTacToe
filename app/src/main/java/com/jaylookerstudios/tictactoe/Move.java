package com.jaylookerstudios.tictactoe;

//helper struct
public class Move {
    public int row;
    public int col;
    public BoardValue board_value;

    public Move(int row, int col, BoardValue board_value) {
        this.row = row;
        this.col = col;
        this.board_value = board_value;
    }
}
