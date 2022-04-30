package com.allmycode.a06_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  TextView numberField;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    numberField = (TextView) findViewById(R.id.numberField);
  }

  public void onButtonClick(View view) {
    long lotsAndLotsOfKids = 2147483647;
    int numberOfDuggarKids;

    numberOfDuggarKids = (int) lotsAndLotsOfKids;

    numberField.setText(Integer.toString(numberOfDuggarKids));
  }
}
