package com.allmycode.a09_04;

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

    BagOfCheese bag = new BagOfCheese();
    bag.kind = "Cheddar";
    bag.weight = 2.43;
    bag.daysAged = 30;
    bag.isDomestic = true;

    textView.setText("");

    textView.append(bag.kind + ", " +  bag.weight + ", " +
        bag.daysAged + ", " + bag.isDomestic + "\n");

    // bag = new BagOfCheese();
    bag.kind = "Blue";
    bag.weight = 5.987;
    bag.daysAged = 90;
    bag.isDomestic = false;

    textView.append(bag.kind + ", " +  bag.weight + ", " +
        bag.daysAged + ", " + bag.isDomestic + "\n");
  }
}


