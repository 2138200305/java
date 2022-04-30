package com.allmycode.a08_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
  EditText ageField;
  CheckBox specialShowingCheckBox;
  TextView outputView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ageField = (EditText) findViewById(R.id.ageField);
    specialShowingCheckBox =
        (CheckBox) findViewById(R.id.specialShowingCheckBox);
    outputView = (TextView) findViewById(R.id.outputView);
  }

  public void onButtonClick(View view) {
    int age = Integer.parseInt(ageField.getText().toString());
    boolean isSpecialShowing = specialShowingCheckBox.isChecked();
    double price;
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    if ((age < 18 || 65 <= age) && !isSpecialShowing) {
      price = 7.00;
    } else {
      price = 10.00;
    }

//    if ((age < 18 || 65 <= age) && !isSpecialShowing)
//      price = 7.00;
//    else
//      price = 10.00;

//    price = 10.00;
//    if ((age < 18 || 65 <= age) && !isSpecialShowing)
//      price = 7.00;

//    price = 10.00;
//    if (age < 18 || 65 <= age) {
//      if (!isSpecialShowing) {
//        price = 7.00;
//      }
//    }

    outputView.setText(currency.format(price));
  }
}
