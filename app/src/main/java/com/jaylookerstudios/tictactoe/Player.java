package com.jaylookerstudios.tictactoe;

//stores information for human and computer player
public class Player {
    private int id;
    private String name;
    private BoardValue board_value;

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

    public BoardValue getBoard_value() {
        return board_value;
    }

    public void setBoard_value(BoardValue board_value) {
        this.board_value = board_value;
    }


    //constructors
    public Player(int id, String name, BoardValue board_value) {
        this.id = id;
        this.name = name;
        this.board_value = board_value;
    }

    //plays a move to board
    public void play_move(Board board, Move move) {
        board.set_move(move);
    }

    //use min-max algorithm to determine best move
    public Move get_best_move(Board board) {
        //todo finish min max algorithm
        Move move = new Move(0,0, this.board_value);
        return move;
    }

    //determines if current player is winning
    public boolean is_winning(Board board) {
        int winning_length = 3;
        for (int i = 0, k = board.getBoard().length - 1; i < board.getBoard().length; i++, k--) {
            int row_total = 0;
            int col_total = 0;
            int diagonal_up = 0;
            int diagonal_down = 0;
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                //check each row
                if (board.getBoard()[i][j] == this.board_value.getBoard_value()) {
                    row_total++;
                }
                //check each col
                if(board.getBoard()[j][i] == this.board_value.getBoard_value()) {
                    col_total++;
                }
            }
            //check long diagonal sloping down
            if (board.getBoard()[i][i] == this.board_value.getBoard_value()) {
                diagonal_down++;
            }
            //check long diagonal sloping up
            if (board.getBoard()[i][k] == this.board_value.getBoard_value()) {
                diagonal_up++;
            }
            if (row_total == winning_length) { return true; }
            if (col_total == winning_length) { return true; }
            if (diagonal_down == winning_length) { return true; }
            if (diagonal_up == winning_length) { return true; }
        }
        return false;
    }
}