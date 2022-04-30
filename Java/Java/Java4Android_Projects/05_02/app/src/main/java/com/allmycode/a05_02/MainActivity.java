package com.allmycode.a05_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    int x = 74;
    System.out.println("Hello, " + "world!");
    System.out.println("The value of x is " + x + ".");
    System.out.println("The second letter of the alphabet is " + 'B' + ".");
    System.out.println("The fifth prime number is " + 11 + '.');
    System.out.println
        ("The sum of 18 and 21 is " + 18 + 21 + ". Oops! That's wrong.");
    System.out.println
        ("The sum of 18 and 21 is " + (18 + 21) + ". That's better.");
  }
}

