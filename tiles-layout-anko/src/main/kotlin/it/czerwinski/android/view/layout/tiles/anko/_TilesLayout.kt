package it.czerwinski.android.view.layout.tiles.anko

import android.app.Activity
import android.content.Context
import android.view.ViewManager
import it.czerwinski.android.view.layout.tiles.TilesLayout
import org.jetbrains.anko.custom.ankoView

inline fun ViewManager.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0): TilesLayout = tilesLayout(cols, rows, theme) {}
inline fun ViewManager.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0, init: TilesLayout.() -> Unit): TilesLayout {
	return ankoView({ TilesLayout(it) }, theme) {
		colsCount = cols
		rowsCount = rows
		init()
	}
}

inline fun Context.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0): TilesLayout = tilesLayout(cols, rows, theme) {}
inline fun Context.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0, init: TilesLayout.() -> Unit): TilesLayout {
	return ankoView({ TilesLayout(it) }, theme) {
		colsCount = cols
		rowsCount = rows
		init()
	}
}

inline fun Activity.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0): TilesLayout = tilesLayout(cols, rows, theme) {}
inline fun Activity.tilesLayout(cols: Int = 1, rows: Int = 1, theme: Int = 0, init: TilesLayout.() -> Unit): TilesLayout {
	return ankoView({ TilesLayout(it) }, theme) {
		colsCount = cols
		rowsCount = rows
		init()
	}
}
