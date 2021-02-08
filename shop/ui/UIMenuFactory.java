package hw5.shop.ui;
import java.util.List;
final class UIMenuFactory implements Factory<UIMenu, UIMenuAction> {
	private Pair<String, UIMenuAction>[] array;
	
	public UIMenu newForm(String heading, List<Pair<String, UIMenuAction>> t) {
		if (null==heading)
			  throw new IllegalArgumentException();
			if (t.size()<=1)
				throw new IllegalStateException();
			for (int i=0;i<t.size();i++) {
				array[i]=t.get(i);
			}
			return null;
	}
}
