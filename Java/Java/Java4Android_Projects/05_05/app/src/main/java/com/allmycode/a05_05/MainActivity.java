package com.allmycode.a05_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    int age;
    boolean isSpecialShowing;
    boolean chargeDiscountPrice;

    age = 13;

    isSpecialShowing = false;
    chargeDiscountPrice = (age < 18 || 65 <= age) && !isSpecialShowing;
    System.out.println(chargeDiscountPrice);

    isSpecialShowing = true;
    chargeDiscountPrice = (age < 18 || 65 <= age) && !isSpecialShowing;
    System.out.println(chargeDiscountPrice);
  }
}
