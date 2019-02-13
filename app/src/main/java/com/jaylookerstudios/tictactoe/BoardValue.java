package com.jaylookerstudios.tictactoe;

public enum BoardValue {
    EMPTY(0, ""),
    X(1, "X"),
    O(2, "O");

    private final int board_value;
    private String display_value;

    private BoardValue(int board_value, String display_value) {
        this.board_value = board_value;
        this.display_value = display_value;
    }

    public int getBoard_value() {
        return board_value;
    }

    public String getDisplay_value() {
        return display_value;
    }
}
