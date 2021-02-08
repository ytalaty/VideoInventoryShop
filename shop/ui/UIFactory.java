package hw5.shop.ui;

public class UIFactory {
  private UIFactory() {}
  static private UI _UI = new PopupUI();
  static private TextUI _TUI = new TextUI();
  static public UI ui () {
    return _UI;
  }
  static public TextUI TUI() {
	  return _TUI;
  }
}
