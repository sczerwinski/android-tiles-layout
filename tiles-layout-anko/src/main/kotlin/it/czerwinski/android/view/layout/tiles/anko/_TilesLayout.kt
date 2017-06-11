package it.czerwinski.android.view.layout.tiles.anko

import android.app.Activity
import android.content.Context
import android.view.ViewManager
import it.czerwinski.android.view.layout.tiles.TilesLayout
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.internals.AnkoInternals

/**
 * Enhancement for `TilesLayout`.
 */
open class _TilesLayout(context: Context) : TilesLayout(context) {

	/**
	 * Single outer and inner padding for the layout.
	 */
	var padding: Int
		@Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
		set(value) {
			setPadding(value, value, value, value)
			innerHorizontalPadding = value
			innerVerticalPadding = value
		}

	/**
	 * Single outer and inner horizontal padding for the layout.
	 */
	var horizontalPadding: Int
		@Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
		set(value) {
			setPadding(value, paddingTop, value, paddingBottom)
			innerHorizontalPadding = value
		}

	/**
	 * Single outer and inner vertical padding for the layout.
	 */
	var verticalPadding: Int
		@Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
		set(value) {
			setPadding(paddingLeft, value, paddingRight, value)
			innerVerticalPadding = value
		}

}

/**
 * Builds `TilesLayout` with Anko.
 *
 * @param cols Number of columns.
 * @param rows Number of rows.
 * @param theme Android theme to be used for the view.
 *
 * @return Created tiles layout.
 */
inline fun ViewManager.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0): TilesLayout =
		tilesLayout(cols, rows, theme) {}

/**
 * Builds `TilesLayout` with Anko.
 *
 * @param cols Number of columns.
 * @param rows Number of rows.
 * @param theme Android theme to be used for the view.
 * @param init Layout initializer function.
 *
 * @return Created tiles layout.
 */
inline fun ViewManager.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0, init: _TilesLayout.() -> Unit): TilesLayout {
	return ankoView({ _TilesLayout(it) }, theme) {
		colsCount = cols
		rowsCount = rows
		init()
	}
}

/**
 * Builds `TilesLayout` with Anko.
 *
 * @param cols Number of columns.
 * @param rows Number of rows.
 * @param theme Android theme to be used for the view.
 *
 * @return Created tiles layout.
 */
inline fun Context.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0): TilesLayout =
		tilesLayout(cols, rows, theme) {}

/**
 * Builds `TilesLayout` with Anko.
 *
 * @param cols Number of columns.
 * @param rows Number of rows.
 * @param theme Android theme to be used for the view.
 * @param init Layout initializer function.
 *
 * @return Created tiles layout.
 */
inline fun Context.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0, init: _TilesLayout.() -> Unit): TilesLayout {
	return ankoView({ _TilesLayout(it) }, theme) {
		colsCount = cols
		rowsCount = rows
		init()
	}
}

/**
 * Builds `TilesLayout` with Anko.
 *
 * @param cols Number of columns.
 * @param rows Number of rows.
 * @param theme Android theme to be used for the view.
 *
 * @return Created tiles layout.
 */
inline fun Activity.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0): TilesLayout =
		tilesLayout(cols, rows, theme) {}

/**
 * Builds `TilesLayout` with Anko.
 *
 * @param cols Number of columns.
 * @param rows Number of rows.
 * @param theme Android theme to be used for the view.
 * @param init Layout initializer function.
 *
 * @return Created tiles layout.
 */
inline fun Activity.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0, init: _TilesLayout.() -> Unit): TilesLayout {
	return ankoView({ _TilesLayout(it) }, theme) {
		colsCount = cols
		rowsCount = rows
		init()
	}
}
