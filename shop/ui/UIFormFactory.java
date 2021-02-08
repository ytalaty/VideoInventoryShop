package hw5.shop.ui;

import java.util.ArrayList;
import java.util.List;

final class UIFormFactory implements Factory<UIForm, UIFormTest> {
	
	private Pair<String, UIFormTest>[] array;
	
	public UIForm newForm(String heading, List<Pair<String ,UIFormTest>> t) {
		if (null==heading)
			throw new IllegalArgumentException();
		if (t.size()<1)
			throw new IllegalStateException();
		for (int i=0;i<t.size();i++)
			array[i] = t.get(i);
		return null;
	}
}
