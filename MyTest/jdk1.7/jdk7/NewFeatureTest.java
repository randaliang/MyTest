package jdk7;

import java.util.List;

public class NewFeatureTest {
	public static <T> void addToList(List<T> listArg, T... elements) {
		for (T x : elements) {
			listArg.add(x);
		}
	}
}
