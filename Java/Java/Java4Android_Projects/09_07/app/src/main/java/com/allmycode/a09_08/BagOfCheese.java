package com.allmycode.a09_08;

public class BagOfCheese {
  public String kind;
  public double weight;
  public int daysAged;
  public boolean isDomestic;

  public BagOfCheese() {
  }

  public BagOfCheese(String dKind, double dWeight,
                     int dDaysAged, boolean dIsDomestic) {
    kind = dKind;
    weight = dWeight;
    daysAged = dDaysAged;
    isDomestic = dIsDomestic;
  }
}
