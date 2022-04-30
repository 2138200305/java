package com.allmycode.a11_01;

import android.view.View;
import android.view.View.OnClickListener;

public class MyOnClickListener implements OnClickListener {
  MainActivity caller;

  public MyOnClickListener(MainActivity activity) {
    caller = activity;
  }

  public void onClick(View view) {
    caller.textView.setText(R.string.you_clicked);
  }
}


