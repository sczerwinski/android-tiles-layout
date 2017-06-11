package it.czerwinski.android.view.layout.tiles;

import android.content.res.Resources;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import it.czerwinski.android.view.layout.tiles.test.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static it.czerwinski.android.view.layout.tiles.ViewMatchers.hasBounds;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TilesLayoutTest {

	@Rule
	public ActivityTestRule<TilesActivity> testRule = new ActivityTestRule<>(TilesActivity.class);

	private int horizontalPadding;
	private int verticalPadding;
	private int innerHorizontalPadding;
	private int innerVerticalPadding;

	@Before
	public void initDimensions() throws Exception {
		Resources res = getInstrumentation().getContext().getResources();
		horizontalPadding = res.getDimensionPixelSize(R.dimen.test_tiles_padding_horizontal);
		verticalPadding = res.getDimensionPixelSize(R.dimen.test_tiles_padding_vertical);
		innerHorizontalPadding = res.getDimensionPixelSize(R.dimen.test_tiles_padding_horizontal_inner);
		innerVerticalPadding = res.getDimensionPixelSize(R.dimen.test_tiles_padding_vertical_inner);
	}

	@Test
	public void layoutShouldBeProperlyInitialized() throws Exception {
		onView(withId(R.id.tiles_layout))
				.check(new ViewAssertion() {
					@Override
					public void check(View view, NoMatchingViewException exception) {
						TilesLayout layout = (TilesLayout) view;
						assertThat("layout is a TilesLayout", layout, isA(TilesLayout.class));
						assertThat("layout columns", layout.getColsCount(), equalTo(2));
						assertThat("layout rows", layout.getRowsCount(), equalTo(3));
						assertThat("layout left padding", layout.getPaddingLeft(), equalTo(horizontalPadding));
						assertThat("layout right padding", layout.getPaddingRight(), equalTo(horizontalPadding));
						assertThat("layout top padding", layout.getPaddingTop(), equalTo(verticalPadding));
						assertThat("layout bottom padding", layout.getPaddingBottom(), equalTo(verticalPadding));
						assertThat("layout inner horizontal padding", layout.getInnerHorizontalPadding(), equalTo(innerHorizontalPadding));
						assertThat("layout inner vertical padding", layout.getInnerVerticalPadding(), equalTo(innerVerticalPadding));
					}
				});
	}

	@Test
	public void layoutShouldFillActivity() throws Exception {
		View contentView = getContentView();
		final int width = contentView.getWidth();
		final int height = contentView.getHeight();

		onView(withId(R.id.tiles_layout))
				.check(new ViewAssertion() {
					@Override
					public void check(View view, NoMatchingViewException exception) {
						TilesLayout layout = (TilesLayout) view;
						assertThat("layout width", layout.getWidth(), equalTo(width));
						assertThat("layout height", layout.getHeight(), equalTo(height));
					}
				});
	}

	@Test
	public void firstViewShouldBeTopLeft() throws Exception {
		View contentView = getContentView();
		final int width = contentView.getWidth();
		final int height = contentView.getHeight();

		onView(withText("Button 1"))
				.check(hasBounds(
						horizontalPadding,
						verticalPadding,
						width / 2 - innerHorizontalPadding / 2,
						(height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 + verticalPadding,
						1));
	}

	@Test
	public void secondViewShouldBeTopRight() throws Exception {
		View contentView = getContentView();
		final int width = contentView.getWidth();
		final int height = contentView.getHeight();

		onView(withText("Button 2"))
				.check(hasBounds(
						width / 2 + innerHorizontalPadding / 2,
						verticalPadding,
						width - horizontalPadding,
						(height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 + verticalPadding,
						1));
	}

	@Test
	public void thirdViewShouldBeMiddleLeft() throws Exception {
		View contentView = getContentView();
		final int width = contentView.getWidth();
		final int height = contentView.getHeight();

		onView(withText("Button 3"))
				.check(hasBounds(
						horizontalPadding,
						(height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 + verticalPadding + innerVerticalPadding,
						width / 2 - innerHorizontalPadding / 2,
						height - (height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 - verticalPadding - innerVerticalPadding,
						1));
	}

	@Test
	public void fourthViewShouldBeMiddleRight() throws Exception {
		View contentView = getContentView();
		final int width = contentView.getWidth();
		final int height = contentView.getHeight();

		onView(withText("Button 4"))
				.check(hasBounds(
						width / 2 + innerHorizontalPadding / 2,
						(height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 + verticalPadding + innerVerticalPadding,
						width - horizontalPadding,
						height - (height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 - verticalPadding - innerVerticalPadding,
						1));
	}

	@Test
	public void fifthViewShouldBeBottomLeft() throws Exception {
		View contentView = getContentView();
		final int width = contentView.getWidth();
		final int height = contentView.getHeight();

		onView(withText("Button 5"))
				.check(hasBounds(
						horizontalPadding,
						height - (height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 - verticalPadding,
						width / 2 - innerHorizontalPadding / 2,
						height - verticalPadding,
						1));
	}

	@Test
	public void sixthViewShouldBeBottomRight() throws Exception {
		View contentView = getContentView();
		final int width = contentView.getWidth();
		final int height = contentView.getHeight();

		onView(withText("Button 6"))
				.check(hasBounds(
						width / 2 + innerHorizontalPadding / 2,
						height - (height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 - verticalPadding,
						width - horizontalPadding,
						height - verticalPadding,
						1));
	}

	private View getContentView() {
		return testRule.getActivity().findViewById(android.R.id.content);
	}
}
