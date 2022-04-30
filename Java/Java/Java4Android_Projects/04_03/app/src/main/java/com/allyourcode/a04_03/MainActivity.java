package com.allyourcode.a04_03;

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
    textView.setText("");

    shout("Help");
    shout("I'm trapped inside a smartphone");

    shout();
  }

  void shout(String message) {
    textView.append(message);
    textView.append("!!! ");
  }

  void shout() {
    textView.append("!!!!!!!");
  }
}
