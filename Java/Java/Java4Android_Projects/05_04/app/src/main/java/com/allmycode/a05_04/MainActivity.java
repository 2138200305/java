package com.allmycode.a05_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    int age;
    boolean chargeDiscountPrice;

    age = 17;
    chargeDiscountPrice = age < 18 || 65 <= age;
    System.out.println(chargeDiscountPrice);

    age = 18;
    chargeDiscountPrice = age < 18 || 65 <= age;
    System.out.println(chargeDiscountPrice);

    age = 75;
    chargeDiscountPrice = age < 18 || 65 <= age;
    System.out.println(chargeDiscountPrice);

  }
}
