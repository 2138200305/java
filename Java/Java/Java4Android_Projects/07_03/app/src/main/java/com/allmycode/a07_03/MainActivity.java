package com.allmycode.a07_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textView = (TextView) findViewById(R.id.textView);

    int score = 50000;
    int points = 1000;
    score = addPoints(score, points);
    textView.setText(Integer.toString(score));
  }

  int addPoints(int score, int points) {
    return score + points;
  }

}
