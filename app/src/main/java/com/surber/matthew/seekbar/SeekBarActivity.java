package com.surber.matthew.seekbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarActivity extends AppCompatActivity {

    public static final String EXTRA_SQUARE_SIZE = "com.matthew.tapthesquare.squaresize";
    private static final int SQUARE_REQUEST_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        final TextView seekbarValueTV = (TextView) findViewById(R.id.seek_bar_value_textview);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        Button showSquare = (Button) findViewById(R.id.display_square_button);

        showSquare.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent launchSquareActivity = new Intent(SeekBarActivity.this, SquareActivity.class);
                launchSquareActivity.putExtra(EXTRA_SQUARE_SIZE, seekBar.getProgress());
                startActivityForResult(launchSquareActivity, SQUARE_REQUEST_CODE);
            }

        });

        int seekbarProgress = seekBar.getProgress();

        seekbarValueTV.setText("The seekbar value is " + seekbarProgress);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarValueTV.setText("The seekbar value is  " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == SQUARE_REQUEST_CODE && resultCode == RESULT_OK) {

            boolean tappedSquare = data.getBooleanExtra(SquareActivity.EXTRA_INSIDE_SQUARE, false);

            if (tappedSquare) {
                Toast.makeText(this, "You tapped the square!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Sorry, you missed the square", Toast.LENGTH_LONG).show();
            }

        }

    }

}
