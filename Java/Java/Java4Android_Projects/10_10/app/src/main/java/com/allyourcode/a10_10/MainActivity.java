package com.allyourcode.a10_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.allyourcode.company.Consultant;
import com.allyourcode.company.Employee;
import com.allyourcode.company.Payable;

public class MainActivity extends AppCompatActivity {
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textView);

    Employee employee = new Employee("Barry", "Author");
    Consultant consultant = new Consultant("Willy", 100.00, 30);

    textView.setText("");

    displayPay(employee);
    displayPay(consultant);
  }

  void displayPay(Payable payable) {
    textView.append(payable.getPayString());
  }
}

