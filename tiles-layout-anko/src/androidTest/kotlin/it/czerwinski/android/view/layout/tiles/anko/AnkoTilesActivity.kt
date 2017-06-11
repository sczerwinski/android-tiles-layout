package it.czerwinski.android.view.layout.tiles.anko

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.dip
import org.jetbrains.anko.horizontalPadding
import org.jetbrains.anko.verticalPadding

class AnkoTilesActivity : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		tilesLayout(cols = 2, rows = 3) {
			horizontalPadding = dip(8)
			verticalPadding = dip(16)
			innerHorizontalPadding = dip(12)
			innerVerticalPadding = dip(24)

			button("Button 1")
			button("Button 2")
			button("Button 3")
			button("Button 4")
			button("Button 5")
			button("Button 6")
		}
	}
}
