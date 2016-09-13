package com.surber.matthew.seekbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class SquareActivity extends AppCompatActivity {

    public static final String EXTRA_INSIDE_SQUARE = "com.matthew.tapthesquare.inside_square";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        Intent launchIntent = getIntent();

        int squareSize = launchIntent.getIntExtra(SeekBarActivity.EXTRA_SQUARE_SIZE, 100);

        ImageView squareView = (ImageView) findViewById(R.id.square);
        ShapeDrawable square = new ShapeDrawable(new RectShape());

        square.setIntrinsicHeight(squareSize);
        square.setIntrinsicWidth(squareSize);

        square.getPaint().setColor(Color.rgb((int) SystemClock.elapsedRealtime() % 256, (int) SystemClock.elapsedRealtime() + 64 % 256, (int) SystemClock.elapsedRealtime() + 32 % 256));

        squareView.setImageDrawable(square);

        squareView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent resultIntent = new Intent();

                resultIntent.putExtra(EXTRA_INSIDE_SQUARE, true);

                setResult(RESULT_OK, resultIntent);

                finish();
            }

        });

        View mainView = findViewById(android.R.id.content);
        mainView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_INSIDE_SQUARE, false);
                setResult(RESULT_OK, resultIntent);
                finish();

            }

        });
    }
}
