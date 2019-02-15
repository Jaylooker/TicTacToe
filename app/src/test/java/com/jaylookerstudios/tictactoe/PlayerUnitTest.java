package com.jaylookerstudios.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerUnitTest {

    @Test
    public void play_move_Correct() {
        Board board = new Board();
        Player player = new Player(0, "test", BoardValue.X);
        Move play_to_0_1 = new Move(0,1, player.getBoard_value());

        player.play_move(board, play_to_0_1);
        //expect the board to have the player's board value at the place played
        assertEquals(player.getBoard_value().getBoard_value(), board.getBoard()[0][1]);
    }

    @Test
    public void get_best_move_Correct() {
        Board board = new Board();
        Player player = new Player(0, "test", BoardValue.X);
        //todo get_ best_move tests
    }

    @Test
    public void is_winning_Correct() {
        //player is using X
        Player player = new Player(0, "test", BoardValue.X);
        //winning
        //diagonal up
        Board board = new Board();
        for (int i = 0; i < board.getBoard().length; i++) {
            board.getBoard()[i][i] = BoardValue.X.getBoard_value();
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if(i != j) {
                    board.getBoard()[i][j] = BoardValue.EMPTY.getBoard_value();
                }
            }
        }
        assertTrue(player.is_winning(board));
        //diagonal down
        board = new Board();
        for (int i = 0, k = board.getBoard().length; i < board.getBoard().length; i++, k--) {
            board.getBoard()[i][k] = BoardValue.X.getBoard_value();
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if ( k != j) {
                    board.getBoard()[i][j] = BoardValue.EMPTY.getBoard_value();
                }
            }
        }
        assertTrue(player.is_winning(board));
        //horizontals
        for (int row = 0; row < board.getBoard().length; row++) {
            board = new Board();
            for (int i = 0; i < board.getBoard().length; i++) {
                for (int j = 0; j < board.getBoard()[i].length; j++) {
                    if(i == row) {
                        board.getBoard()[i][j] = BoardValue.X.getBoard_value();
                    }
                    else {
                        board.getBoard()[i][j] = BoardValue.EMPTY.getBoard_value();
                    }
                }
            }
            assertTrue(player.is_winning(board));
        }
        //verticals
        for (int col = 0; col < board.getBoard().length; col++) {
            board = new Board();
            for (int i = 0; i < board.getBoard().length; i++) {
                for (int j = 0; j < board.getBoard()[i].length; j++) {
                    if(j == col) {
                        board.getBoard()[i][j] = BoardValue.X.getBoard_value();
                    }
                    else {
                        board.getBoard()[i][j] = BoardValue.EMPTY.getBoard_value();
                        }
                    }

            }
            assertTrue(player.is_winning(board));
        }

        //not winning
        board = new Board();
        int [][] not_winning = new int[][] { {BoardValue.O.getBoard_value(), BoardValue.EMPTY.getBoard_value(), BoardValue.O.getBoard_value()} ,
                {BoardValue.O.getBoard_value(), BoardValue.EMPTY.getBoard_value(), BoardValue.O.getBoard_value()},
                {BoardValue.EMPTY.getBoard_value(), BoardValue.X.getBoard_value(), BoardValue.EMPTY.getBoard_value()}};
        board.setBoard(not_winning);
        assertFalse(player.is_winning(board));

    }

    @Test
    public void get_possible_moves_Correct() {
        //keep reducing the available moves until the board is full
        Player player = new Player(0, "test", BoardValue.X);
        Board board = new Board();
        int expected = 9;
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                    assertEquals(expected, player.get_possible_moves(board).size());
                    board.getBoard()[i][j] = BoardValue.O.getBoard_value();
                    expected--;
                }
            }
    }
}
