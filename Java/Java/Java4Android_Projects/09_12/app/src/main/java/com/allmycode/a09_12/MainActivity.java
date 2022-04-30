package com.allmycode.a09_12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.allmycode.a09_10.BagOfCheese;

public class MainActivity extends AppCompatActivity {
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textView);

    BagOfCheese bag1 = new BagOfCheese("Cheddar", 2.43, 30, true);

    addOneDay(bag1);

    textView.setText("");
    textView.append(bag1.toString());
  }

  void addOneDay(BagOfCheese bag) {
    bag.daysAged++;
  }

}