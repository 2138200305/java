package com.allmycode.a05_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    int age;
    boolean chargeRegularPrice;

    age = 17;
    chargeRegularPrice = 18 <= age && age < 65;
    System.out.println(chargeRegularPrice);

    age = 18;
    chargeRegularPrice = 18 <= age && age < 65;
    System.out.println(chargeRegularPrice);

    age = 75;
    chargeRegularPrice = 18 <= age && age < 65;
    System.out.println(chargeRegularPrice);
  }
}
