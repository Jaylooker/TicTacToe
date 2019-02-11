package com.jaylookerstudios.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //board and computaton values
    int[][] board = new int[3][3];
    public enum BoardValues {
        EMPTY(0),
        X(1),
        O(2);

        private final int value;

        private BoardValues(int value) {
            this.value = value;
        }
    }
    //players
    Player human = new Player(0, "You", BoardValues.X.value);
    Player computer = new Player(1, "Computer", BoardValues.O.value);

    TextView txt_win_text = (TextView) findViewById(R.id.txt_win_text);
    Button btn_restart = (Button) findViewById(R.id.btn_restart);
    //board buttons
    Button btn_top_left = (Button) findViewById(R.id.btn_top_left);
    Button btn_top_middle = (Button) findViewById(R.id.btn_top_middle);
    Button btn_top_right = (Button) findViewById(R.id.btn_top_right);
    Button btn_middle_left = (Button) findViewById(R.id.btn_middle_left);
    Button btn_center = (Button) findViewById(R.id.btn_center);
    Button btn_bottom_left = (Button) findViewById(R.id.btn_bottom_left);
    Button btn_bottom_middle = (Button) findViewById(R.id.btn_bottom_middle);
    Button btn_bottom_right = (Button) findViewById(R.id.btn_bottom_right);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void OnRestartClick (View v) {
        //reset board
        board = new int[3][3];
        //reset display
        txt_win_text.setText("");
        //display board text views set to " "
    }

    private void OnBoardClick (View v) {
        Button button = (Button) v;
        String display_character = (String) button.getText();
        if(!display_character.equals("")) {
            button.setText(getString(R.string.X));
        }
    }
}
