package com.allmycode.a06_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  EditText ageField;
  CheckBox specialShowingCheckBox;
  TextView outputField;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ageField = (EditText) findViewById(R.id.ageField);
    specialShowingCheckBox =
        (CheckBox) findViewById(R.id.specialShowingCheckBox);
    outputField = (TextView) findViewById(R.id.outputField);
  }

  public void onButtonClick(View view) {
    int age = Integer.parseInt(ageField.getText().toString());
    boolean isSpecialShowing = specialShowingCheckBox.isChecked();

    boolean chargeDiscountPrice = (age < 18 || 65 <= age) && !isSpecialShowing;
    outputField.setText(Boolean.toString(chargeDiscountPrice));
  }
}
