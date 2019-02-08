package com.jaylookerstudios.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //board and computaton values. Adding to 3 or -3 is a win.
    final static byte X = 1;
    final static byte O = -1;
    byte[][] board = new byte[3][3];
    //players
    final static String PLAYER_1 = "Player 1";
    final static String COMPUTER = "Computer";
    //board display values
    final static String X_VALUE = "X";
    final static String O_VALUE = "O";
    final static String EMPTY_VALUE = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt_win_text = (TextView) findViewById(R.id.txt_win_text);
        Button btn_restart = (Button) findViewById(R.id.btn_restart);

        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset board
                board = new byte[3][3];
                //reset display
                txt_win_text.setText("");
                //display board text views set to " "
            }
        });

    }

    //use min-max algorithm to determine best move
    private void get_best_move(byte[][] board, String player) {

    }

    private String is_winning(byte[][] board) {
        if (board[0][0] + board[0][1] + board[0][2] == 3 ||
                board[1][0] + board[1][1] + board[1][2] == 3 ||
                board[2][0] + board[2][1] + board[2][2] == 3 ||
                board[0][0] + board[1][0] + board[2][0] == 3 ||
                board[0][1] + board[1][1] + board[2][1] == 3 ||
                board[0][2] + board[1][2] + board[2][2] == 3 ||
                board[0][0] + board[1][1] + board[2][2] == 3 ||
                board[2][0] + board[1][1] + board[0][0] == 3)
        {
            return PLAYER_1;
        }
        else if (board[0][0] + board[0][1] + board[0][2] == -3 ||
                board[1][0] + board[1][1] + board[1][2] == -3 ||
                board[2][0] + board[2][1] + board[2][2] == -3 ||
                board[0][0] + board[1][0] + board[2][0] == -3 ||
                board[0][1] + board[1][1] + board[2][1] == -3 ||
                board[0][2] + board[1][2] + board[2][2] == -3 ||
                board[0][0] + board[1][1] + board[2][2] == -3 ||
                board[2][0] + board[1][1] + board[0][0] == -3)
        {
            return COMPUTER;
        }
        else {
            return "";
        }

    }
}
