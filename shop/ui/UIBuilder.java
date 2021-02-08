package hw5.shop.ui;

import java.util.ArrayList;
import java.util.List;

final class UIBuilder<Test, Form, T extends Factory<Form,Test>> {
	final T t;
	final Test test;
	final Form form;
	      
	private final List<Pair<String,Test>> _menu = new ArrayList<Pair<String,Test>>();
	
	UIBuilder(T t, Test test, Form form){
		this.t = t;
		this.test = test;
		this.form = form;
	}
	
	
	  public void add(String prompt, T test) {
		  Pair pair = new Pair(prompt, test);
		    _menu.add(pair);
		  }
	  public Form toForm(String heading) {
		  if(heading == null) {
			  throw new IllegalArgumentException();
		  }
		  if (_menu.size() < 1) {
		      throw new IllegalStateException();
		  }
			    return t.newForm(heading, _menu);

	  }

}
