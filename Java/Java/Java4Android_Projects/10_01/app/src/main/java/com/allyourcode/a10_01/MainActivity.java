package com.allyourcode.a10_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Employee employee = new Employee();
    employee.name = "Sam";

    FullTimeEmployee ftEmployee = new FullTimeEmployee();
    ftEmployee.name = "Jennie";

    Executive executive = new Executive();
    executive.name = "Harriet";
  }
}
