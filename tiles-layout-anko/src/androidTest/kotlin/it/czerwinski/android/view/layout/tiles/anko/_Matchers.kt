package it.czerwinski.android.view.layout.tiles.anko

import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.matcher.ViewMatchers.assertThat
import android.view.View
import org.hamcrest.Matchers.closeTo

typealias ViewAssertion = (View, NoMatchingViewException?) -> Unit

fun hasBounds(left: Int, top: Int, right: Int, bottom: Int, error: Int = 1): ViewAssertion = { view, _ ->
	assertThat("view left bound", view.left.toDouble(), closeTo(left.toDouble(), error.toDouble()))
	assertThat("view right bound", view.right.toDouble(), closeTo(right.toDouble(), error.toDouble()))
	assertThat("view top bound", view.top.toDouble(), closeTo(top.toDouble(), error.toDouble()))
	assertThat("view bottom bound", view.bottom.toDouble(), closeTo(bottom.toDouble(), error.toDouble()))
}