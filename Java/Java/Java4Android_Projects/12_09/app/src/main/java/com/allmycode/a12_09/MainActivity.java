package com.allmycode.a12_09;

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

    String[] stringsA = { "Hello,", "I", "must", "be", "going." };
    String[] stringsB = { "    ", "-Groucho" };
    String[] stringsC = { "Say", "Goodnight,", "Gracie." };
    String[] stringsD = { "    ", "-Nathan Birnbaum" };
    String[] stringsE = { "Goodbye,", "kids." };
    String[] stringsF = { "    ", "-Clarabell" };

    textView.setText("");

    displayAsSentence(stringsA);
    displayAsSentence(stringsB);
    displayAsSentence(stringsC);
    displayAsSentence(stringsD);
    displayAsSentence(stringsE);
    displayAsSentence(stringsF);
  }

  void displayAsSentence(String[] words) {
    for (String word : words) {
      textView.append(word);
      textView.append(" ");
    }
    textView.append("\n");
  }
}
