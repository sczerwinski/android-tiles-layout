package it.czerwinski.android.view.layout.tiles.anko

import android.app.Activity
import android.content.Context
import android.view.ViewManager
import it.czerwinski.android.view.layout.tiles.TilesLayout
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.internals.AnkoInternals

class _TilesLayout(context: Context) : TilesLayout(context) {

	var padding: Int
		@Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
		set(value) {
			setPadding(value, value, value, value)
			innerHorizontalPadding = value
			innerVerticalPadding = value
		}

	var horizontalPadding: Int
		@Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
		set(value) {
			setPadding(value, paddingTop, value, paddingBottom)
			innerHorizontalPadding = value
		}

	var verticalPadding: Int
		@Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
		set(value) {
			setPadding(paddingLeft, value, paddingRight, value)
			innerVerticalPadding = value
		}

}

inline fun ViewManager.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0): TilesLayout = tilesLayout(cols, rows, theme) {}
inline fun ViewManager.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0, init: _TilesLayout.() -> Unit): TilesLayout {
	return ankoView({ _TilesLayout(it) }, theme) {
		colsCount = cols
		rowsCount = rows
		init()
	}
}

inline fun Context.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0): TilesLayout = tilesLayout(cols, rows, theme) {}
inline fun Context.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0, init: _TilesLayout.() -> Unit): TilesLayout {
	return ankoView({ _TilesLayout(it) }, theme) {
		colsCount = cols
		rowsCount = rows
		init()
	}
}

inline fun Activity.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0): TilesLayout = tilesLayout(cols, rows, theme) {}
inline fun Activity.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0, init: _TilesLayout.() -> Unit): TilesLayout {
	return ankoView({ _TilesLayout(it) }, theme) {
		colsCount = cols
		rowsCount = rows
		init()
	}
}
