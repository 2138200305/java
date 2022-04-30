package com.allmycode.a07_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
  TextView paymentView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    paymentView = (TextView) findViewById(R.id.paymentView);
  }

  public void onButtonClick(View view) {
    double principal = 100000.00, ratePercent = 5.25;
    double payment;
    int years = 30;
    String paymentString;

    payment = monthlyPayment(principal, ratePercent, years);

    NumberFormat currency = NumberFormat.getCurrencyInstance();
    paymentString = currency.format(payment);
    paymentView.setText(paymentString);
  }

  double monthlyPayment(double dPrincipal, double dRatePercent, int dYears) {
    double rate, effectiveAnnualRate;
    int paymentsPerYear = 12, numberOfPayments;

    rate = dRatePercent / 100.00;
    numberOfPayments = paymentsPerYear * dYears;
    effectiveAnnualRate = rate / paymentsPerYear;

    return dPrincipal * (effectiveAnnualRate /
        (1 - Math.pow(1 + effectiveAnnualRate, -numberOfPayments)));
  }

}
