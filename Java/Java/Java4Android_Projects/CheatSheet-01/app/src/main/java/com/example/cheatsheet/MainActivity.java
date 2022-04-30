package com.example.cheatsheet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  EditText editText;
  TextView textView;

  int myInt = 42;
  double myDouble = 27649.00;
  boolean myBoolean = true;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editText = (EditText) findViewById(R.id.editText);
    textView = (TextView) findViewById(R.id.textView);
  }

  public void onButtonClick(View view) {
    char myChar = 'B';
    String myString = "Hello";
    ArrayList<String> myList = new ArrayList<String>();
    String[] myArray = {"This ", "is ", "an ", "array."};

    textView.append("myInt is " + Integer.toString(myInt) + "\n");
    textView.append("myChar is " + Character.toString(myChar) + "\n");
    Toast.makeText(this, myString, Toast.LENGTH_LONG).show();
    textView.append("myInt + myString + \" \" + myDouble is ");
    textView.append(myInt + " " + myString + " " + myDouble + "\n");

    try {
      myInt = Integer.parseInt(editText.getText().toString());
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }

    textView.append("myInt is ");
    if (myInt < 5) {
      textView.append("small\n");
    } else {
      textView.append("large\n");
    }

    textView.append("Is myBoolean true? ");
    if (myBoolean) {
      textView.append("Yes\n");
    }

    textView.append("myInt is ");
    switch (myInt) {
      case 1:
        textView.append("one\n");
        break;
      case 2:
      case 3:
        textView.append("a small number\n");
        break;
      default:
        textView.append("a lot\n");
        break;
    }

    for (int i = 0; i < 10; i++) {
      textView.append(Integer.toString(i));
      textView.append(" ");
    }
    textView.append("\n");

    int i = 0;
    while (i < 10) {
      textView.append(i++ + " ");
    }
    textView.append("\n");

    int j = 0;
    do {
      textView.append(Integer.toString(j++));
      textView.append(j <= 9 ? ", " : "");
    } while (j < 10);
    textView.append("\n");

    myList.add("Three ");
    myList.add("cheers ");
    myList.add("for ");
    myList.add("Captain ");
    myList.add("Spaulding");
    for (String word : myList) {
      textView.append(word);
    }
    textView.append("\n");

    textView.append(addPeriod("Spaulding"));
    textView.append("\n");

    for (int n = 0; n < myArray.length; n++) {
      textView.append(myArray[n]);
    }
    textView.append("\n");
  }

  String addPeriod(String string) {
    return string + ".";
  }

}
