package com.jaylookerstudios.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardUnitTest {
    @Test
    public void is_full_Correct() {
        Board board = new Board();

        //empty
        assertFalse(board.is_full());
        //not completely full, diagonal is has O's
        for(int i = 0; i < board.getBoard().length; i++) {
            board.getBoard()[i][i] = BoardValue.O.getBoard_value();
        }
        assertFalse(board.is_full());
        //full of X's
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                board.getBoard()[i][j] = BoardValue.X.getBoard_value();
            }
        }
        assertTrue(board.is_full());

    }


}
