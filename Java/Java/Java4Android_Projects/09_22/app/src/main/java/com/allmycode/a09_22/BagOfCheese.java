// BAD CODE!!! GO TO YOUR ROOM, CODE.
package com.allmycode.a09_22;

public class BagOfCheese {
  public String kind;
  public double weight;
  public int daysAged;
  public boolean isDomestic;

  private int count = 0;

  public static int getCount() {
    return count;                 // ERROR!
  }

  public BagOfCheese() {
    count++;
  }
}

