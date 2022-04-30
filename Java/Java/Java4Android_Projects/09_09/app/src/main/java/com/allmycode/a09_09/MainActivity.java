package com.allmycode.a09_09;

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

    BagOfCheese bag1 = new BagOfCheese("Cheddar", 2.43, 30, true);
    BagOfCheese bag2 = new BagOfCheese("Blue", 5.987, 90, false);

    textView.setText("");

    displayBag(bag1);
    displayBag(bag2);
  }

  private void displayBag(BagOfCheese bag) {
    textView.append(bag.kind + ", " +  bag.weight + ", " +
        bag.daysAged + ", " + bag.isDomestic + "\n");
  }
}
