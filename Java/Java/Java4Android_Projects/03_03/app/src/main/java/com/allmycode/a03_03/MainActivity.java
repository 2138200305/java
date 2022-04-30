package com.allmycode.a03_03; // The code in this file belongs to
                              // a package named com.allmycode.a04_01.

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;         // This code uses things that are coded in
import android.view.View;         // other packages -- packages such as
import android.widget.EditText;   // android.widget.EditText, android.os.View,
import android.widget.TextView;   // and others.

public class MainActivity extends AppCompatActivity {
                          // This code defines a class.
                          // The class's name is MainActivity.
                          // This code inherits all the features described in
                          // Android's built-in AppCompatActivity code.
                          // An AppCompatActivity is a kind of Activity.
                          // An Activity is one screenful of stuff that the
                          // user sees. So, this code describes one screenful
                          // for the user.
  EditText editText;
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
                                                 // When an Android device
                                                 // creates this screenful
                                                 // of stuff...

    super.onCreate(savedInstanceState);        // ... the device recovers
                                               // relevant info from the
                                               // last time this screenful
                                               // appeared, and ...

    setContentView(R.layout.activity_main);    // ... displays the layout
                                               // that's described in
                                               // Listing 3-1.
    editText = (EditText) findViewById(R.id.editText);
    textView = (TextView) findViewById(R.id.textView);
  }

  public void onButtonClick(View view) {
    textView.setText(editText.getText());
  }
}
