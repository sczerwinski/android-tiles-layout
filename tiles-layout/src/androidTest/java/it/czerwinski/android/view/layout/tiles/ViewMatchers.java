package it.czerwinski.android.view.layout.tiles;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.view.View;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class ViewMatchers {

	public static ViewAssertion hasBounds(
			final int left, final int top, final int right, final int bottom, final int error) {
		return new ViewAssertion() {
			@Override
			public void check(View view, NoMatchingViewException exception) {
				assertThat("view left bound", (double) view.getLeft(), closeTo(left, error));
				assertThat("view right bound", (double) view.getRight(), closeTo(right, error));
				assertThat("view top bound", (double) view.getTop(), closeTo(top, error));
				assertThat("view bottom bound", (double) view.getBottom(), closeTo(bottom, error));
			}
		};
	}
}
