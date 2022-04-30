package com.allmycode.a12_04;

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

    OrderedPair<BagOfCheese> pair = new OrderedPair<>();

    BagOfCheese bag = new BagOfCheese();
    bag.kind = "Muenster";
    pair.setX(bag);

    bag = new BagOfCheese();
    bag.kind = "Brie";
    pair.setY(bag);

    textView.setText("");
    textView.append(pair.getX().kind);
    textView.append("\n");
    textView.append(pair.getY().kind);
  }
}
