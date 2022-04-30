package com.allmycode.a08_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  EditText numberLeftField, numberRightField;
  TextView operatorView, resultView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    numberLeftField = (EditText) findViewById(R.id.numberLeftField);
    numberRightField = (EditText) findViewById(R.id.numberRightField);
    operatorView = (TextView) findViewById(R.id.operatorView);
    resultView = (TextView) findViewById(R.id.resultView);
  }

  public void onButtonClick(View view) {
    double numberLeft =
        Double.parseDouble(numberLeftField.getText().toString());
    double numberRight =
        Double.parseDouble(numberRightField.getText().toString());
    String operatorSymbol = "";
    double result;

    switch (view.getId()) {
      case R.id.buttonAdd:
        operatorSymbol = "+";
        result = numberLeft + numberRight;
        break;
      case R.id.buttonSubtract:
        operatorSymbol = "-";
        result = numberLeft - numberRight;
        break;
      case R.id.buttonMultiply:
        operatorSymbol = "x";
        result = numberLeft * numberRight;
        break;
      case R.id.buttonDivide:
        operatorSymbol = "/";
        result = numberLeft / numberRight;
        break;
      default:
        operatorSymbol = "?";
        result = 0;
        break;
    }

    operatorView.setText(operatorSymbol);

    if (Double.isInfinite(result) || Double.isNaN(result)) {
      resultView.setText("Bad value!");
    } else {
      resultView.setText(Double.toString(result));
    }
  }
}
