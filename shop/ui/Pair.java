package hw5.shop.ui;

final class Pair<X,Y> {
	final Y test;
	final X prompt;
	
	Pair(X thePrompt, Y theAction) {
		prompt = thePrompt;
		test = theAction;
	}
}
