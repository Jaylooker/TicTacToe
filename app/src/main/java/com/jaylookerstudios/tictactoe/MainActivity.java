package com.jaylookerstudios.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //board
    Board board = new Board();
    //players
    Player user = new Player(0, "You", BoardValue.X);
    Player computer = new Player(1, "Computer", BoardValue.O);

    TextView txt_win_text;
    Button btn_restart;
    //board
    GridLayout board_layout;
    Button btn_top_left;
    Button btn_top_middle;
    Button btn_top_right;
    Button btn_middle_left;
    Button btn_center;
    Button btn_middle_right;
    Button btn_bottom_left;
    Button btn_bottom_middle;
    Button btn_bottom_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intialize views
        txt_win_text = (TextView) findViewById(R.id.txt_win_text);
        btn_restart = (Button) findViewById(R.id.btn_restart);
        //board
        board_layout = (GridLayout) findViewById(R.id.board_layout);
        btn_top_left = (Button) findViewById(R.id.btn_top_left);
        btn_top_middle = (Button) findViewById(R.id.btn_top_middle);
        btn_top_right = (Button) findViewById(R.id.btn_top_right);
        btn_middle_left = (Button) findViewById(R.id.btn_middle_left);
        btn_center = (Button) findViewById(R.id.btn_center);
        btn_middle_right = (Button) findViewById(R.id.btn_middle_right);
        btn_bottom_left = (Button) findViewById(R.id.btn_bottom_left);
        btn_bottom_middle = (Button) findViewById(R.id.btn_bottom_middle);
        btn_bottom_right = (Button) findViewById(R.id.btn_bottom_right);

        //todo user and computer keep playing moves until the board is full
    }

    public void OnRestartClick (View v) {
        //reset board
        board = new Board();
        //reset display
        txt_win_text.setText("");
        //display board text views set to ""
        btn_top_left.setText(BoardValue.EMPTY.getDisplay_value());
        btn_top_middle.setText(BoardValue.EMPTY.getDisplay_value());
        btn_top_right.setText(BoardValue.EMPTY.getDisplay_value());
        btn_middle_left.setText(BoardValue.EMPTY.getDisplay_value());
        btn_center.setText(BoardValue.EMPTY.getDisplay_value());
        btn_middle_right.setText(BoardValue.EMPTY.getDisplay_value());
        btn_bottom_left.setText(BoardValue.EMPTY.getDisplay_value());
        btn_bottom_middle.setText(BoardValue.EMPTY.getDisplay_value());
        btn_bottom_right.setText(BoardValue.EMPTY.getDisplay_value());
    }

    //set the button clicked to the user's board value
    public void OnBoardButtonClick (View v) {
        Button button = (Button) v;
        String display_character = (String) button.getText();
        if(display_character.equals(BoardValue.EMPTY.getDisplay_value())) {
            //get button's row and column and set to the board
            int row = 0;
            int col = 0;
            switch (button.getId()) {
                case R.id.btn_top_left: row = 0;
                    col = 0;
                    break;
                case R.id.btn_top_middle: row = 0;
                    col = 1;
                    break;
                case R.id.btn_top_right: row = 0;
                    col = 2;
                    break;
                case R.id.btn_middle_left: row = 1;
                    col = 0;
                    break;
                case R.id.btn_center: row = 1;
                    col = 1;
                    break;
                case R.id.btn_middle_right: row = 1;
                    col = 0;
                    break;
                case R.id.btn_bottom_left: row = 2;
                    col = 0;
                    break;
                case R.id.btn_bottom_middle: row = 2;
                    col = 1;
                    break;
                case R.id.btn_bottom_right: row = 2;
                    col = 2;
                    break;
            }
            Move move = new Move(row, col, user.getBoard_value());
            user.play_move(board, move);

            //set user's display value to the button
            button.setText(user.getBoard_value().getDisplay_value());
        }
    }

}