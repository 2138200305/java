package com.allyourcode.a10_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.allyourcode.company.Employee;
import com.allyourcode.company.FullTimeEmployee;
import com.allyourcode.company.Executive;
import com.allyourcode.company.PartTimeEmployee;

public class MainActivity extends AppCompatActivity {
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textView);

    Employee employee = new Employee("Barry", "Author");

    FullTimeEmployee ftEmployee =
        new FullTimeEmployee("Ed", "Manager", 10000.00);

    PartTimeEmployee ptEmployee =
        new PartTimeEmployee("Joe", "Intern", 8.00, 20);

    Executive executive =
        new Executive("Jane", "CEO", 20000.00, 5000.00);

    textView.setText("");

    textView.append(employee.getPayString());
    textView.append(ftEmployee.getPayString());
    textView.append(ptEmployee.getPayString());
    textView.append(executive.getPayString());
  }
}
