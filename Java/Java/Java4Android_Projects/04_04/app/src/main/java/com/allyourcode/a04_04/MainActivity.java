/*
 * Listing 4-4 in
 *   "Java Programming for Android Developers For Dummies, 2nd Edition"
 *
 * Copyright 2016 Wiley Publishing, Inc.
 * All rights reserved.
 */

package com.allyourcode.a04_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * MainActivity displays Hello World! on the screen.
 *
 * @author  Barry Burd
 * @version 1.0 07/07/16
 */
public class MainActivity extends AppCompatActivity {

  /**
   * Called when Android creates this activity.
   *
   * @param savedInstanceState
   *
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);       // Restores any previous state
    setContentView(R.layout.activity_main);   // Makes activity_main.xml be
  }                                           //   the layout file
}
