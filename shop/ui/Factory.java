package hw5.shop.ui;

import java.util.List;

public interface Factory<Form, Test> {
	Form newForm(String id, List<Pair<String ,Test>> i);
}
