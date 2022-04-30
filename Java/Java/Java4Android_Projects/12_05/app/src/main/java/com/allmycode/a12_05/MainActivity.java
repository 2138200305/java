package com.allmycode.a12_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textView);

    ArrayList arrayList = new ArrayList();
    arrayList.add("Hello");
    arrayList.add(", ");
    arrayList.add("readers");
    arrayList.add("!");

    textView.setText("");

    Iterator<String> iterator = arrayList.iterator();

    while (iterator.hasNext()) {
      textView.append(iterator.next());
    }
  }
}
