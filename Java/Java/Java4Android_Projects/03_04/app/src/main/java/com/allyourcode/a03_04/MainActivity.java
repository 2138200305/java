package com.allyourcode.a03_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {
  EditText editText;
  Button button;
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editText = (EditText) findViewById(R.id.editText);
    button = (Button) findViewById(R.id.button);
    textView = (TextView) findViewById(R.id.textView);

    button.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    textView.setText(editText.getText());
  }
}
