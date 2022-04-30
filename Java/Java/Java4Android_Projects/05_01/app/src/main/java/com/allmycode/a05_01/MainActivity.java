package com.allmycode.a05_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    int anInteger = 74;
    char aCharacter = 74;

    System.out.println(anInteger);
    System.out.println(aCharacter);
  }
}
