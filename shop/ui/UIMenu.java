package hw5.shop.ui;

/**
 * @see UIMenuBuilder
 */
public final class UIMenu extends UIMenuForm {

  UIMenu(String heading, Pair<String,UIMenuAction>[] menu) {
    _heading = heading;
    _menu = menu;
  }
  
  public void runAction(int i) {
    ((UIMenuAction) _menu[i].action).run();
  }
}
