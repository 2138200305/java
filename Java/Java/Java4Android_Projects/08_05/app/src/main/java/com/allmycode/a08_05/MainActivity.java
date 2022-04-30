package com.allmycode.a08_05;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textView);
  }

  public void onButtonClick(View view) {
    Random random = new Random();
    String message;
    int winCount = 0, loseCount = 0;

    for (int i = 1; i <= 100; i++) {
      int numberA = random.nextInt(6) + 1;
      int numberB = random.nextInt(6) + 1;
      int total = numberA + numberB;
      message = getMessage(total);

      if (message.equals("win")) {
        winCount++;
      } else if (message.equals("lose")) {
        loseCount++;
      }
    }

    textView.setText("Wins: " + winCount + "\nLosses: " + loseCount);
  }

  String getMessage(int total) {
    switch (total) {
      case 7:
      case 11:
        return "win";
      case 2:
      case 3:
      case 12:
        return "lose";
      case 4:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
        return "continue";
      default:
        return "not a valid dice roll";
    }
  }
}
