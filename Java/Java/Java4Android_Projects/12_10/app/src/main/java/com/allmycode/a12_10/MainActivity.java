package com.allmycode.a12_10;

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

    displayAsSentence("Hello,", "I", "must", "be", "going.");
    displayAsSentence("    ", "-Groucho");
    displayAsSentence("Say", "Goodnight,", "Gracie.");
    displayAsSentence("    ", "-Nathan Birnbaum");
    displayAsSentence("Goodbye,", "kids.");
    displayAsSentence("    ", "-Clarabell");
  }

  void displayAsSentence(String... words) {
    for (String word : words) {
      textView.append(word);
      textView.append(" ");
    }
    textView.append("\n");
  }
}
