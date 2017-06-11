package it.czerwinski.android.view.layout.tiles.anko

import android.app.Activity
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import it.czerwinski.android.view.layout.tiles.TilesLayout
import org.hamcrest.Matchers.*
import org.jetbrains.anko.dip
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class AnkoTilesLayoutHVPaddingTest {

	@Rule
	@JvmField
	val testRule = ActivityTestRule<AnkoTilesHVPaddingActivity>(AnkoTilesHVPaddingActivity::class.java)

	private val activity: Activity
		get() = testRule.activity

	private val horizontalPadding: Int
		get() = activity.dip(8)

	private val verticalPadding: Int
		get() = activity.dip(16)

	@Test
	@Throws(Exception::class)
	fun layoutShouldBeProperlyInitialized() {
		onView(withClassName(containsString(TilesLayout::class.java.simpleName)))
				.check { view, _ ->
					val layout = view as TilesLayout
					assertThat("layout left padding", layout.paddingLeft, equalTo(horizontalPadding))
					assertThat("layout right padding", layout.paddingRight, equalTo(horizontalPadding))
					assertThat("layout top padding", layout.paddingTop, equalTo(verticalPadding))
					assertThat("layout bottom padding", layout.paddingBottom, equalTo(verticalPadding))
					assertThat("layout inner horizontal padding", layout.innerHorizontalPadding, equalTo(horizontalPadding))
					assertThat("layout inner vertical padding", layout.innerVerticalPadding, equalTo(verticalPadding))
				}
	}
}
