package hw5.shop.ui;

/**
 * @see UIFormBuilder
 */
public final class UIForm extends UIMenuForm{
  UIForm(String heading, Pair<String,UIFormTest>[] menu) {
    _heading = heading;
    _menu = menu;
  }

  public boolean checkInput(int i, String input) {
    if (null == _menu[i])
      return true;
    return ((UIFormTest) _menu[i].action).run(input);
  }
}
