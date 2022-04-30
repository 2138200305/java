package com.allmycode.a09_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.allmycode.a09_01.BagOfCheese;

public class MainActivity extends AppCompatActivity {
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textView);

    BagOfCheese bag1 = new BagOfCheese();
    bag1.kind = "Cheddar";
    bag1.weight = 2.43;
    bag1.daysAged = 30;
    bag1.isDomestic = true;

    BagOfCheese bag2 = new BagOfCheese();
    bag2.kind = "Blue";
    bag2.weight = 5.987;
    bag2.daysAged = 90;
    bag2.isDomestic = false;

    textView.setText("");

    textView.append(bag1.kind + ", " +  bag1.weight + ", " +
        bag1.daysAged + ", " + bag1.isDomestic + "\n");

    textView.append(bag2.kind + ", " + bag2.weight + ", " +
        bag2.daysAged + ", " + bag2.isDomestic + "\n");
  }
}
