package it.czerwinski.android.view.layout.tiles.anko

import android.app.Activity
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import it.czerwinski.android.view.layout.tiles.TilesLayout
import org.hamcrest.Matchers.*
import org.jetbrains.anko.dip
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class AnkoTilesLayoutTest {

	@Rule
	@JvmField
	val testRule = ActivityTestRule<AnkoTilesActivity>(AnkoTilesActivity::class.java)

	private val activity: Activity
		get() = testRule.activity

	private val contentView: View
		get() = activity.findViewById(android.R.id.content)

	private val width: Int
		get() = contentView.width

	private val height: Int
		get() = contentView.height

	private val horizontalPadding: Int
		get() = activity.dip(8)

	private val verticalPadding: Int
		get() = activity.dip(16)

	private val innerHorizontalPadding: Int
		get() = activity.dip(12)

	private val innerVerticalPadding: Int
		get() = activity.dip(24)

	@Test
	@Throws(Exception::class)
	fun layoutShouldBeProperlyInitialized() {
		onView(withClassName(containsString(TilesLayout::class.java.simpleName)))
				.check { view, _ ->
					val layout = view as TilesLayout
					assertThat("layout is a TilesLayout", layout, isA(TilesLayout::class.java))
					assertThat("layout columns", layout.colsCount, equalTo(2))
					assertThat("layout rows", layout.rowsCount, equalTo(3))
					assertThat("layout left padding", layout.paddingLeft, equalTo(horizontalPadding))
					assertThat("layout right padding", layout.paddingRight, equalTo(horizontalPadding))
					assertThat("layout top padding", layout.paddingTop, equalTo(verticalPadding))
					assertThat("layout bottom padding", layout.paddingBottom, equalTo(verticalPadding))
					assertThat("layout inner horizontal padding", layout.innerHorizontalPadding, equalTo(innerHorizontalPadding))
					assertThat("layout inner vertical padding", layout.innerVerticalPadding, equalTo(innerVerticalPadding))
				}
	}

	@Test
	@Throws(Exception::class)
	fun layoutShouldFillActivity() {
		onView(withClassName(containsString(TilesLayout::class.java.simpleName)))
				.check { view, _ ->
					val layout = view as TilesLayout
					assertThat("layout width", layout.width, equalTo(width))
					assertThat("layout height", layout.height, equalTo(height))
				}
	}

	@Test
	@Throws(Exception::class)
	fun firstViewShouldBeTopLeft() {
		onView(withText("Button 1"))
				.check(hasBounds(
						horizontalPadding,
						verticalPadding,
						width / 2 - innerHorizontalPadding / 2,
						(height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 + verticalPadding))
	}

	@Test
	@Throws(Exception::class)
	fun secondViewShouldBeTopRight() {
		onView(withText("Button 2"))
				.check(hasBounds(
						width / 2 + innerHorizontalPadding / 2,
						verticalPadding,
						width - horizontalPadding,
						(height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 + verticalPadding))
	}

	@Test
	@Throws(Exception::class)
	fun thirdViewShouldBeMiddleLeft() {
		onView(withText("Button 3"))
				.check(hasBounds(
						horizontalPadding,
						(height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 + verticalPadding + innerVerticalPadding,
						width / 2 - innerHorizontalPadding / 2,
						height - (height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 - verticalPadding - innerVerticalPadding))
	}

	@Test
	@Throws(Exception::class)
	fun fourthViewShouldBeMiddleRight() {
		onView(withText("Button 4"))
				.check(hasBounds(
						width / 2 + innerHorizontalPadding / 2,
						(height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 + verticalPadding + innerVerticalPadding,
						width - horizontalPadding,
						height - (height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 - verticalPadding - innerVerticalPadding))
	}

	@Test
	@Throws(Exception::class)
	fun fifthViewShouldBeBottomLeft() {
		onView(withText("Button 5"))
				.check(hasBounds(
						horizontalPadding,
						height - (height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 - verticalPadding,
						width / 2 - innerHorizontalPadding / 2,
						height - verticalPadding))
	}

	@Test
	@Throws(Exception::class)
	fun sixthViewShouldBeBottomRight() {
		onView(withText("Button 6"))
				.check(hasBounds(
						width / 2 + innerHorizontalPadding / 2,
						height - (height - 2 * verticalPadding - 2 * innerVerticalPadding) / 3 - verticalPadding,
						width - horizontalPadding,
						height - verticalPadding))
	}
}
