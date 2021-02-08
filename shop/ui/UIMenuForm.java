package hw5.shop.ui;

public class UIMenuForm {

	protected String _heading;
	protected Pair[] _menu;
	
	protected static final class Pair<T,U> {
		final T prompt;
		final U action;
		
		Pair(T thePrompt, U theAction) {
			prompt = thePrompt;
			action = theAction;
		}
	}
	
	public UIMenuForm() {
		super();
	}
	
	public int size() {
		return _menu.length;
	}
	
	public String getHeading() {
		return _heading;
	}
	
	public <T> Object getPrompt(int i) {
		return _menu[i].prompt;
	}
}
