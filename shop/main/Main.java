package hw5.shop.main;

import hw5.shop.ui.UIFactory;
import hw5.shop.data.Data;

public class Main {
  private Main() {}
  public static void main(String[] args) {
    Control control = new Control(Data.newInventory(), UIFactory.ui());
    control.run();
  }
}
