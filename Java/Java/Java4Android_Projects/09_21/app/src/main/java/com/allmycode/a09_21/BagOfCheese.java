package com.allmycode.a09_21;

public class BagOfCheese {
  public String kind;
  public double weight;
  public int daysAged;
  public boolean isDomestic;

  private static int count = 0;

  public static int getCount() {
    return count;
  }

  public BagOfCheese() {
    count++;
  }
}
